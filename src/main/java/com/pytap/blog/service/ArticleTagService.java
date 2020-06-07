package com.pytap.blog.service;

import com.pytap.blog.model.domain.Article;
import com.pytap.blog.model.domain.ArticleTag;
import com.pytap.blog.model.domain.Tag;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 21:42
 */
public interface ArticleTagService {

	/**
	 * 插入文章标签
	 * @param articleTag 文章标签实体
	 * @return Integer 返回结果
	 * */
	Integer insertArticleTag(ArticleTag articleTag);

	/**
	 * 批量插入文章标签
	 * @param articleTagList 文章标签实体
	 * @return Integer 返回结果
	 * */
	Integer insertArticleTagList(List<ArticleTag> articleTagList);

	/**
	 * 主键删除文章标签
	 * @param id 文章标签id
	 * @return Integer 返回结果
	 * */
	Integer deleteArticleTagById(Long id);

	/**
	 * 更新文章标签
	 * @param articleTag 文章标签实体
	 * @return Integer 返回结果
	 * */
	Integer updateArticleTag(ArticleTag articleTag);

	/**
	 * 通过文章id获取所有标签
	 * @param id 文章id
	 * @return List<Tag>
	 * */
	List<Tag> listAllTagsByArticleId(Long id);

	/**
	 * 获取标签文章数量
	 * @param name 标签名
	 * @return Long 数量
	 * */
	Long countArticlesByTagName(String name);

	/**
	 * 通过标签名获取文章
	 * @param pageNum 第几页
	 * @param pageSize 每页多少
	 * @param name 标签名
	 * @return List<Article>
	 * */
	List<Article> listArticlesByTagName(Integer pageNum, Integer pageSize, String name);

}
