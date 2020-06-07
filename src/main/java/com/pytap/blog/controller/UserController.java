package com.pytap.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.blog.model.domain.User;
import com.pytap.blog.model.dto.UserDTO;
import com.pytap.blog.service.CommonService;
import com.pytap.blog.service.UserService;
import com.pytap.blog.utils.FinalUtil;
import com.pytap.blog.utils.JsonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Ecin520
 * @date 2020/5/16 1:13
 */
@CrossOrigin
@RestController
public class UserController {

	@Resource
	private UserService userService;

	@Resource
	private CommonService commonService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public JSONObject login(String username, String password) {
		String token = commonService.login(username, password);
		UserDTO userDTO = userService.getUserDtoByUsername(username);
		return JsonUtil.loginSuccess(token, userDTO);
	}

	@RequestMapping(value = "/getUserById", method = RequestMethod.GET)
	public JSONObject getUserById(Long id) {
		UserDTO userDTO = userService.getUserDtoById(id);
		return JsonUtil.result(userDTO);
	}

	@RequestMapping(value = "/getUserByUsername", method = RequestMethod.GET)
	public JSONObject getUserByUsername(String username) {
		UserDTO userDTO = userService.getUserDtoByUsername(username);
		return JsonUtil.result(userDTO);
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public JSONObject updateUser(@RequestBody User user) {
		return userService.updateUser(user) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

}
