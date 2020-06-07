package com.pytap.blog.service;

/**
 * @author Ecin520
 * @date 2020/5/22 12:28
 */
public interface CommonService {
	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 * @return String
	 * */
	String login(String username, String password);

	/**
	 * 注销
	 * @param username 用户名
	 * @param password 密码
	 * @return String
	 * */
	Integer logout(String username, String password);
}
