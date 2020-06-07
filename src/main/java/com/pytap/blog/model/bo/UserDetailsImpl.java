package com.pytap.blog.model.bo;

import com.pytap.blog.model.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/22 11:41
 */
public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 9061159403035701438L;

	private final User user;

	private final String auth;

	public UserDetailsImpl(User user, String auth) {
		this.user = user;
		this.auth = auth;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(auth);
		list.add(simpleGrantedAuthority);
		return list;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.getStatus().equals(1);
	}
}
