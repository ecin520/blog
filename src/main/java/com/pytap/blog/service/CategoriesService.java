package com.pytap.blog.service;

import com.pytap.blog.model.domain.Categories;
import com.pytap.blog.model.domain.Tag;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 21:40
 */
public interface CategoriesService {

	/**
	 * 插入分类
	 * @param categories 分类实体
	 * @return Integer 返回结果
	 * */
	Integer insertCategories(Categories categories);

	/**
	 * 主键删除分类
	 * @param id 分类id
	 * @return Integer 返回结果
	 * */
	Integer deleteCategoriesById(Long id);

	/**
	 * 更新分类
	 * @param categories 分类实体
	 * @return Integer 返回结果
	 * */
	Integer updateCategories(Categories categories);

	/**
	 * 获取分类
	 * @param id 分类id
	 * @return Categories 返回结果
	 * */
	Categories getCategoriesById(Long id);

	/**
	 * 名称获取分类
	 * @param name 分类名称
	 * @return Categories 返回结果
	 * */
	Categories getCategoriesByName(String name);

	/**
	 * 获取所有分类
	 * @return List<Categories>
	 * */
	List<Categories> listAllCategories();

}
