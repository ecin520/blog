package com.pytap.blog.model.dto;

import com.pytap.blog.model.domain.Categories;
import com.pytap.blog.model.domain.Tag;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/16 2:00
 */
@Data
public class ArticleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long creater;

	private String title;

	private String generalize;

	private String time;

	private String showImage;

	private Integer recommend;

	private Long likes;

	private Long views;

	private String content;

	private List<Tag> tags;

	private List<Categories> categories;

}
