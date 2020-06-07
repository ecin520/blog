package com.pytap.blog.service.impl;

import com.pytap.blog.dao.UserMapper;
import com.pytap.blog.model.domain.User;
import com.pytap.blog.model.domain.UserExample;
import com.pytap.blog.model.dto.UserDTO;
import com.pytap.blog.service.UserService;
import com.pytap.blog.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 23:17
 */
@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public Integer insertUser(User user) {
		user.setCreateTime(DateUtil.getDateFormat());
		return userMapper.insert(user);
	}

	@Override
	public Integer updateUser(User user) {
		return userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public UserDTO getUserDtoById(Long id) {
		UserDTO userDTO = new UserDTO();
		User user = userMapper.selectByPrimaryKey(id);
		BeanUtils.copyProperties(user, userDTO);
		return userDTO;
	}

	@Override
	public User getUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public UserDTO getUserDtoByUsername(String username) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		User user = userMapper.selectByExample(userExample).get(0);
		UserDTO userDTO = new UserDTO();
		BeanUtils.copyProperties(user, userDTO);
		return userDTO;
	}

	@Override
	public User getUserByUsername(String username) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		return userMapper.selectByExample(userExample).get(0);
	}


	@Override
	public List<UserDTO> listAllUsers() {
		List<User> list = userMapper.selectByExample(null);
		List<UserDTO> result = new ArrayList<>(16);
		for (User user : list) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
			result.add(userDTO);
		}
		return result;
	}
}
