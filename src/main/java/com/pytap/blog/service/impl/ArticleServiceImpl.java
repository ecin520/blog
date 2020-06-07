package com.pytap.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.pytap.blog.dao.ArticleCategoriesMapper;
import com.pytap.blog.dao.ArticleMapper;
import com.pytap.blog.dao.ArticleTagMapper;
import com.pytap.blog.model.domain.*;
import com.pytap.blog.model.dto.ArticleDTO;
import com.pytap.blog.service.ArticleCategoriesService;
import com.pytap.blog.service.ArticleService;
import com.pytap.blog.service.ArticleTagService;
import com.pytap.blog.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ecin520
 * @date 2020/5/15 23:12
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper articleMapper;

	@Resource
	private ArticleTagService articleTagService;

	@Resource
	private ArticleTagMapper articleTagMapper;

	@Resource
	private ArticleCategoriesService articleCategoriesService;

	@Resource
	private ArticleCategoriesMapper articleCategoriesMapper;

	@Override
	public Long countArticles() {
		return articleMapper.countByExample(null);
	}

	@Override
	@Transactional(rollbackFor = {RuntimeException.class, Error.class})
	public Integer deleteArticleById(Long id) {

		// 删除文章标签
		ArticleTagExample articleTagExample = new ArticleTagExample();
		articleTagExample.createCriteria().andArticleIdEqualTo(id);
		articleTagMapper.deleteByExample(articleTagExample);

		// 删除文章分类
		ArticleCategoriesExample articleCategoriesExample = new ArticleCategoriesExample();
		articleCategoriesExample.createCriteria().andArticleIdEqualTo(id);
		articleCategoriesMapper.deleteByExample(articleCategoriesExample);

		return articleMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(rollbackFor = {RuntimeException.class, Error.class})
	public Integer insertArticle(ArticleDTO articleDTO) {

		Article article = new Article();
		BeanUtils.copyProperties(articleDTO, article);
		article.setTime(DateUtil.getDateFormat());
		articleMapper.insert(article);

		if (insertArticleTagAndCategory(articleDTO.getTags(), articleDTO.getCategories(),article.getId()) == 1) {
			return 1;
		}
		return -1;


	}



	@Override
	@Transactional(rollbackFor = {RuntimeException.class, Error.class})
	public Integer insertArticleTagAndCategory(List<Tag> tags, List<Categories> categories, Long id) {

		for (Tag tag : tags) {
			ArticleTag articleTag = new ArticleTag();
			articleTag.setTagId(tag.getId());
			articleTag.setArticleId(id);
			articleTagService.insertArticleTag(articleTag);
		}

		for (Categories category : categories) {
			ArticleCategories articleCategories = new ArticleCategories();
			articleCategories.setCategoriesId(category.getId());
			articleCategories.setArticleId(id);
			articleCategoriesService.insertArticleCategories(articleCategories);
		}

		return 1;

	}

	@Override
	@Transactional(rollbackFor = {RuntimeException.class, Error.class})
	public Integer updateArticle(ArticleDTO articleDTO) {

		// 复制Bean到Article对象
		Article article = new Article();
		BeanUtils.copyProperties(articleDTO, article);
		articleMapper.updateByPrimaryKeyWithBLOBs(article);

		// 删除文章标签
		ArticleTagExample articleTagExample = new ArticleTagExample();
		articleTagExample.createCriteria().andArticleIdEqualTo(article.getId());
		articleTagMapper.deleteByExample(articleTagExample);

		// 删除文章分类
		ArticleCategoriesExample articleCategoriesExample = new ArticleCategoriesExample();
		articleCategoriesExample.createCriteria().andArticleIdEqualTo(article.getId());
		articleCategoriesMapper.deleteByExample(articleCategoriesExample);

		// 插入文章标签和分类
		insertArticleTagAndCategory(articleDTO.getTags(), articleDTO.getCategories(),article.getId());

		return 1;
	}

	@Override
	public Article getArticleById(Long id) {
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Article> listArticlesByUserId(Long id) {
		ArticleExample articleExample = new ArticleExample();
		articleExample.createCriteria().andCreaterEqualTo(id);
		return articleMapper.selectByExampleWithBLOBs(articleExample);
	}

	@Override
	public List<Article> listArticles(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		ArticleExample articleExample = new ArticleExample();
		articleExample.setOrderByClause("time DESC");
		return articleMapper.selectByExampleWithBLOBs(articleExample);
	}

	@Override
	public List<Article> listRecommendArticles() {
		ArticleExample articleExample = new ArticleExample();
		articleExample.createCriteria().andRecommendEqualTo(1);
		return articleMapper.selectByExampleWithBLOBs(articleExample);
	}

	@Override
	public List<ArticleDTO> listArticleDtosByList(List<Article> articles) {
		List<ArticleDTO> result = new ArrayList<>(16);
		for (Article article : articles) {
			System.out.println(article.getId());
			ArticleDTO articleDTO = new ArticleDTO();
			BeanUtils.copyProperties(article, articleDTO);
			articleDTO.setTags(articleTagService.listAllTagsByArticleId(article.getId()));
			articleDTO.setCategories(articleCategoriesService.listAllCategoriesByArticleId(article.getId()));
			result.add(articleDTO);
		}
		return result;
	}

	@Override
	public ArticleDTO getArticleDto(Article article) {
		ArticleDTO articleDTO = new ArticleDTO();
		BeanUtils.copyProperties(article, articleDTO);
		articleDTO.setTags(articleTagService.listAllTagsByArticleId(article.getId()));
		articleDTO.setCategories(articleCategoriesService.listAllCategoriesByArticleId(article.getId()));
		return articleDTO;
	}

	@Override
	public List<String> listArticleYears() {

		List<Article> articles = articleMapper.selectByExampleWithBLOBs(null);
		List<String> result = new ArrayList<>(16);
		Set<String> set = new HashSet<>(16);

		for (Article article : articles) {
			set.add(article.getTime().split("-")[0]);
		}

		result.addAll(set);

		return result;
	}

	@Override
	public List<ArticleDTO> listArticleDtosByYear(Integer pageNum, Integer pageSize, String year) {
		ArticleExample articleExample = new ArticleExample();
		articleExample.createCriteria().andTimeLike(year + "%");
		PageHelper.startPage(pageNum, pageSize);
		List<Article> articles = articleMapper.selectByExampleWithBLOBs(articleExample);

		return listArticleDtosByList(articles);
	}

	@Override
	public Long countYearArticles(String year) {
		ArticleExample articleExample = new ArticleExample();
		articleExample.createCriteria().andTimeLike(year + "%");
		return articleMapper.countByExample(articleExample);
	}
}
