package com.pytap.blog.schedule;

import com.alibaba.fastjson.JSONObject;
import com.pytap.blog.model.domain.Views;
import com.pytap.blog.service.ViewsService;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 定时器获取网站统计数据
 * @author Ecin520
 * @date 2020/5/23 0:35
 */
@Component
public class Scheduler {

	@Resource
	private ViewsService viewsService;

	public String now() {
		String[] strNow = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).split("-");
		return strNow[0] + strNow[1] + strNow[2];
	}

	@Scheduled(fixedRate = 60000)
	public void updateViews() {

		HttpClient httpClient = HttpClients.createDefault();

		String baseUrl = "https://openapi.baidu.com/rest/2.0/tongji/report/getData?";
		String accessToken = "access_token=121.bd7094514996e2cc0b9a7357f287421b.Yl6751bK11z2qaIjMmS9fRGlJQXhKy3H99HXHsS.SbjJ5g";
		String siteId = "&site_id=15113920";
		String startDate = "&start_date=20200501";
		String endDate = "&end_date=" + now();
		String metrics = "&metrics=pv_count%2Cvisitor_count%2Cip_count";
		String method = "&method=overview%2FgetTimeTrendRpt";

		String url = baseUrl + accessToken + siteId + startDate + endDate + metrics + method;

		HttpPost post = new HttpPost(url);
		post.setHeader("content-type", "text/xml");

		try {
			HttpResponse response = httpClient.execute(post);
			String text = EntityUtils.toString(response.getEntity());
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				System.out.println(text);
				Map<String, Object> map = JSONObject.parseObject(text);

				@SuppressWarnings("unchecked")
				Map<String, Object> result = (Map<String, Object>) map.get("result");

				@SuppressWarnings("unchecked")
				List<List<Object>> lists = (List<List<Object>>) result.get("items");

				@SuppressWarnings("unchecked")
				List<Integer> list = (List<Integer>) lists.get(1).get(lists.get(1).size() - 1);

				List<Object> visit = lists.get(1);

				int allVis = 0;

				for (Object o : visit) {

					@SuppressWarnings("unchecked")
					List<Object> temp = (List<Object>) o;

					if (!"--".equals(temp.get(0).toString())) {
						allVis += Integer.parseInt(temp.get(0).toString());
					}

				}

				Views views = new Views();
				views.setId(1000L);
				views.setAllViews((long) allVis);
				views.setDayViews(Long.valueOf(list.get(0)));
				views.setVisNum(Long.valueOf(list.get(1)));
				views.setIpNum(Long.valueOf(list.get(2)));

				viewsService.updateViews(views);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
