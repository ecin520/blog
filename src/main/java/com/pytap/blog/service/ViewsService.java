package com.pytap.blog.service;

import com.pytap.blog.model.domain.Views;

/**
 * @author Ecin520
 * @date 2020/5/23 0:41
 */
public interface ViewsService {

	/**
	 * 获取访问量
	 * @return Views
	 * */
	Views getViews();

	/**
	 * 更新访问量
	 * @return Integer 返回结果
	 * */
	Integer updateViews(Views views);

}
