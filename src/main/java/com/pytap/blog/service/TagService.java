package com.pytap.blog.service;

import com.pytap.blog.model.domain.Tag;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 21:38
 */
public interface TagService {

	/**
	 * 插入标签
	 * @param tag 标签实体
	 * @return Integer 返回结果
	 * */
	Integer insertTag(Tag tag);

	/**
	 * 主键删除标签
	 * @param id 标签id
	 * @return Integer 返回结果
	 * */
	Integer deleteTagById(Long id);

	/**
	 * 更新标签
	 * @param tag 标签实体
	 * @return Integer 返回结果
	 * */
	Integer updateTag(Tag tag);

	/**
	 * 主键获取标签
	 * @param id 标签id
	 * @return Tag 返回结果
	 * */
	Tag getTagById(Long id);

	/**
	 * 名称获取标签
	 * @param name 标签名称
	 * @return Tag 返回结果
	 * */
	Tag getTagByName(String name);

	/**
	 * 获取所有标签
	 * @return List<Tag>
	 * */
	List<Tag> listAllTags();

}
