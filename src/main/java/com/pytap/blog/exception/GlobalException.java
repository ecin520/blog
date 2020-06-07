package com.pytap.blog.exception;

import com.alibaba.fastjson.JSONObject;
import com.pytap.blog.utils.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Ecin520
 * @date 2020/5/16 1:28
 */
@RestControllerAdvice
public class GlobalException {

	private static final Logger logger = LoggerFactory.getLogger(GlobalException.class);

	/**
	 * 用户不存在
	 * */
	@ExceptionHandler(value = UsernameNotFoundException.class)
	public JSONObject usernameNotFoundException(UsernameNotFoundException e) {
		logger.error(e.getMessage());
		return JsonUtil.noAuth(e.getMessage());
	}

	/**
	 * 用户已被禁用
	 * */
	@ExceptionHandler(value = DisabledException.class)
	public JSONObject disabledException(DisabledException e) {
		logger.error(e.getMessage());
		return JsonUtil.noAuth(e.getMessage());
	}

	/**
	 * 无访问权限异常
	 * */
	@ExceptionHandler(value = AccessDeniedException.class)
	public JSONObject accessDeniedException(AccessDeniedException e) {
		logger.error(e.getMessage());
		return JsonUtil.noAuth(e.getMessage());
	}

	/**
	 * 无访问权限异常
	 * */
	@ExceptionHandler(value = BadCredentialsException.class)
	public JSONObject badCredentialsException(BadCredentialsException e) {
		logger.error(e.getMessage());
		return JsonUtil.noAuth(e.getMessage());
	}




}
