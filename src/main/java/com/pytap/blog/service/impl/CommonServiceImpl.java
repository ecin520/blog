package com.pytap.blog.service.impl;

import com.pytap.blog.service.CommonService;
import com.pytap.blog.utils.JwtTokenUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/5/22 12:27
 */
@Service
public class CommonServiceImpl implements CommonService {

	@Resource
	private JwtTokenUtil jwtTokenUtil;

	@Resource
	private UserDetailsService userDetailsService;


	@Override
	public String login(String username, String password) {
		String token;
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		System.out.println(userDetails.getPassword());
		if (!password.equals(userDetails.getPassword())) {
			throw new BadCredentialsException("密码错误");
		}
		if (!userDetails.isEnabled()) {
			throw new DisabledException("账户已被禁用");
		}
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		token = jwtTokenUtil.generateToken(userDetails);
		return token;
	}

	@Override
	public Integer logout(String username, String password) {
		return null;
	}

}
