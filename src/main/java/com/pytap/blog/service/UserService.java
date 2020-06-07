package com.pytap.blog.service;

import com.pytap.blog.model.domain.User;
import com.pytap.blog.model.dto.UserDTO;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 21:15
 */
public interface UserService {

	/**
	 * 插入用户
	 * @param user 用户实体
	 * @return Integer 返回结果
	 * */
	Integer insertUser(User user);


	/**
	 * 用户更新
	 * @param user 用户实体
	 * @return Integer 返回结果
	 * */
	Integer updateUser(User user);

	/**
	 * 主键获取用户传输对象
	 * @param id 用户id
	 * @return UserDTO 用户传输对象
	 * */
	UserDTO getUserDtoById(Long id);

	/**
	 * 主键获取用户对象
	 * @param id 用户id
	 * @return User 用户传输对象
	 * */
	User getUserById(Long id);


	/**
	 * 用户名获取用户传输对象
	 * @param username 用户名
	 * @return UserDTO 用户传输对象
	 * */
	UserDTO getUserDtoByUsername(String username);

	/**
	 * 用户名获取用户对象
	 * @param username 用户名
	 * @return User 用户传输对象
	 * */
	User getUserByUsername(String username);


	/**
	 * 获取所有用户
	 * @return List<UserDTO> 返回结果
	 * */
	List<UserDTO> listAllUsers();
}
