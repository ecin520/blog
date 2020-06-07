package com.pytap.blog.service;

import com.pytap.blog.model.domain.Article;
import com.pytap.blog.model.domain.Categories;
import com.pytap.blog.model.domain.Tag;
import com.pytap.blog.model.dto.ArticleDTO;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 21:20
 */
public interface ArticleService {

	/**
	 * 获取文章总数量，以便分页
	 * @return Long 结果
	 * */
	Long countArticles();

	/**
	 * 插入文章
	 * @param articleDTO 文章实体
	 * @return Integer 返回结果
	 * */
	Integer insertArticle(ArticleDTO articleDTO);

	/**
	 * 主键删除文章
	 * @param id 文章id
	 * @return Integer 返回结果
	 * */
	Integer deleteArticleById(Long id);

	/**
	 * 更新文章
	 * @param articleDTO 文章实体
	 * @return Integer 返回结果
	 * */
	Integer updateArticle(ArticleDTO articleDTO);

	/**
	 * 获取文章
	 * @param id 文章
	 * @return Article 返回结果
	 * */
	Article getArticleById(Long id);

	/**
	 * 获取用户所有文章
	 * @param id 用户id
	 * @return List<Article>
	 * */
	List<Article> listArticlesByUserId(Long id);

	/**
	 * 获取所有文章

	 * @return List<Article>
	 * */
	List<Article> listArticles(Integer pageNum, Integer pageSize);

	/**
	 * 获取推荐文章
	 * @return List<Article>
	 * */
	List<Article> listRecommendArticles();

	/**
	 * 通过Article列表获取Article传输对象
	 * @param articles 文章列表
	 * @return List<ArticleDTO>
	 * */
	List<ArticleDTO> listArticleDtosByList(List<Article> articles);

	/**
	 * 通过Article获取Article传输对象
	 * @param article 文章
	 * @return ArticleDTO
	 * */
	ArticleDTO getArticleDto(Article article);

	/**
	 * 获取文章所有年份
	 * @return List<String>
	 * */
	List<String> listArticleYears();

	/**
	 * 通过年份获取文章列表
	 * @return List<ArticleDTO>
	 * */
	List<ArticleDTO> listArticleDtosByYear(Integer pageNum, Integer pageSize, String year);

	/**
	 * 获取年份文章总数
	 * @param year 年份
	 * @return Long
	 * */
	Long countYearArticles(String year);

	/**
	 * 通过文章id插入标签和分类
	 * @param id 文章id
	 * @param tags 标签
	 * @param categories 分类
	 * @return Integer 返回结果
	 *
	 */
	Integer insertArticleTagAndCategory(List<Tag> tags, List<Categories> categories, Long id);

}
