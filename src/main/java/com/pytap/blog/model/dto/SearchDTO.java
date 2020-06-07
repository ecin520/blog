package com.pytap.blog.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ecin520
 * @date 2020/5/23 10:52
 */
@Data
public class SearchDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private String generalize;
}
