package com.pytap.blog.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ecin520
 * @date 2020/5/15 21:16
 */
@Data
public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String avatar;

	private String email;

	private String tel;

	private String nickname;

	private String signature;

	private String createTime;

	private String auth;

	private Long views;

	private Integer status;
}
