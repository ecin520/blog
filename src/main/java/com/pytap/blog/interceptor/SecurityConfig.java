package com.pytap.blog.interceptor;

import com.pytap.blog.model.bo.UserDetailsImpl;
import com.pytap.blog.model.domain.User;
import com.pytap.blog.service.UserService;
import com.pytap.blog.utils.JwtTokenUtil;
import io.jsonwebtoken.Jwt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/5/22 11:23
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Resource
	private UserService userService;



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin/**")
				.hasRole("ADMIN")
				.anyRequest().permitAll().and()
				.csrf()
				.disable()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.NEVER);

		// 禁用缓存
		http.headers().cacheControl();

		// 添加JWT Filter
		http.addFilterBefore(jwtAuthTokenFilter(), UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		return username -> {
			User user = userService.getUserByUsername(username);
			if (null != user) {
				return new UserDetailsImpl(user, user.getAuth());
			} else {
				throw new UsernameNotFoundException("用户不存在");
			}
		};
	}

	@Bean
	public JwtTokenUtil jwtTokenUtil() {
		return new JwtTokenUtil();
	}

	@Bean
	public JwtAuthTokenFilter jwtAuthTokenFilter() {
		return new JwtAuthTokenFilter();
	}


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}


	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManagerBean();
	}
}
