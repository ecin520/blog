package com.pytap.blog.utils;

import com.alibaba.fastjson.JSONObject;
import com.pytap.blog.model.dto.UserDTO;

/**
 * @author Ecin520
 * @date 2020/5/15 21:18
 */
public class JsonUtil {

	public static JSONObject success() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", FinalUtil.SUCCESS_CODE);
		jsonObject.put("content", "操作成功");
		return jsonObject;
	}

	public static JSONObject fail() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", FinalUtil.FAIL_CODE);
		jsonObject.put("content", "操作失败");
		return jsonObject;
	}

	public static JSONObject result(Object object) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", FinalUtil.SUCCESS_CODE);
		jsonObject.put("content", object);
		return jsonObject;
	}

	public static JSONObject loginSuccess(String token, Object user) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", FinalUtil.SUCCESS_CODE);
		jsonObject.put("token", token);
		jsonObject.put("user", user);
		return jsonObject;
	}

	public static JSONObject noAuth(String content) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", FinalUtil.NO_AUTH);
		jsonObject.put("content", content);
		return jsonObject;
	}

}
