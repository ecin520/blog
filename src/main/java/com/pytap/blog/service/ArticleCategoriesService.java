package com.pytap.blog.service;

import com.pytap.blog.model.domain.Article;
import com.pytap.blog.model.domain.ArticleCategories;
import com.pytap.blog.model.domain.Categories;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 21:57
 */
public interface ArticleCategoriesService {

	/**
	 * 插入文章分类
	 * @param articleCategories 文章分类实体
	 * @return Integer 返回结果
	 * */
	Integer insertArticleCategories(ArticleCategories articleCategories);

	/**
	 * 批量插入文章分类
	 * @param articleCategoriesList 文章分类实体
	 * @return Integer 返回结果
	 * */
	Integer insertArticleCategoriesList(List<ArticleCategories> articleCategoriesList);

	/**
	 * 主键删除文章分类
	 * @param id 文章分类id
	 * @return Integer 返回结果
	 * */
	Integer deleteArticleCategoriesById(Long id);

	/**
	 * 更新文章分类
	 * @param articleCategories 文章分类实体
	 * @return Integer 返回结果
	 * */
	Integer updateArticleCategories(ArticleCategories articleCategories);

	/**
	 * 通过文章id获取所有分类
	 * @param id 文章id
	 * @return List<Categories>
	 * */
	List<Categories> listAllCategoriesByArticleId(Long id);

	/**
	 * 获取分类文章数量
	 * @param name 分类名
	 * @return Long 数量
	 * */
	Long countArticlesByCategoriesName(String name);

	/**
	 * 通过标签名获取文章
	 * @param pageNum 第几页
	 * @param pageSize 每页多少
	 * @param name 分类名
	 * @return List<Article>
	 * */
	List<Article> listArticlesByCategoriesName(Integer pageNum, Integer pageSize, String name);

}
