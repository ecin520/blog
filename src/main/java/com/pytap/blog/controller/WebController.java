package com.pytap.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.blog.model.dto.UserDTO;
import com.pytap.blog.service.ViewsService;
import com.pytap.blog.service.WebService;
import com.pytap.blog.utils.JsonUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/5/23 0:54
 */
@CrossOrigin
@RestController
public class WebController {

	@Resource
	private ViewsService viewsService;

	@Resource
	private WebService webService;

	@RequestMapping(value = "/getViews", method = RequestMethod.GET)
	public JSONObject getViews() {
		return JsonUtil.result(viewsService.getViews());
	}

	@RequestMapping(value = "/selectAllValues", method = RequestMethod.GET)
	public JSONObject selectAllValues() {
		return JsonUtil.result(webService.selectAllValues());
	}

}
