package com.pytap.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.pytap.blog.dao.ArticleCategoriesMapper;
import com.pytap.blog.dao.ArticleMapper;
import com.pytap.blog.dao.CategoriesMapper;
import com.pytap.blog.model.domain.*;
import com.pytap.blog.service.ArticleCategoriesService;
import com.pytap.blog.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 23:07
 */
@Service
public class ArticleCategoriesServiceImpl implements ArticleCategoriesService {

	@Resource
	private ArticleCategoriesMapper articleCategoriesMapper;

	@Resource
	private CategoriesMapper categoriesMapper;

	@Resource
	private ArticleMapper articleMapper;

	@Override
	public Integer insertArticleCategories(ArticleCategories articleCategories) {
		articleCategories.setCreateTime(DateUtil.getDateFormat());
		return articleCategoriesMapper.insert(articleCategories);
	}

	@Override
	public Integer insertArticleCategoriesList(List<ArticleCategories> articleCategoriesList) {
		for (ArticleCategories articleCategories : articleCategoriesList) {
			articleCategoriesMapper.insert(articleCategories);
		}
		return 1;
	}

	@Override
	public Integer deleteArticleCategoriesById(Long id) {
		return articleCategoriesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateArticleCategories(ArticleCategories articleCategories) {
		return articleCategoriesMapper.updateByPrimaryKey(articleCategories);
	}

	@Override
	public List<Categories> listAllCategoriesByArticleId(Long id) {
		ArticleCategoriesExample articleCategoriesExample = new ArticleCategoriesExample();
		articleCategoriesExample.createCriteria().andArticleIdEqualTo(id);
		List<ArticleCategories> articleCategories = articleCategoriesMapper.selectByExample(articleCategoriesExample);
		List<Categories> categories = new ArrayList<>(16);
		for (ArticleCategories articleCategory : articleCategories) {
			categories.add(categoriesMapper.selectByPrimaryKey(articleCategory.getCategoriesId()));
		}
		return categories;
	}

	@Override
	public Long countArticlesByCategoriesName(String name) {

		// 获取分类id
		CategoriesExample categoriesExample = new CategoriesExample();
		categoriesExample.createCriteria().andNameEqualTo(name);
		Categories categories = categoriesMapper.selectByExample(categoriesExample).get(0);

		// 通过分类id获取文章Example
		ArticleCategoriesExample articleCategoriesExample = new ArticleCategoriesExample();
		articleCategoriesExample.createCriteria().andCategoriesIdEqualTo(categories.getId());

		return articleCategoriesMapper.countByExample(articleCategoriesExample);
	}

	@Override
	public List<Article> listArticlesByCategoriesName(Integer pageNum, Integer pageSize, String name) {

		// 获取分类id
		CategoriesExample categoriesExample = new CategoriesExample();
		categoriesExample.createCriteria().andNameEqualTo(name);
		Categories categories = categoriesMapper.selectByExample(categoriesExample).get(0);

		// 通过分类id获取所有文章id
		ArticleCategoriesExample articleCategoriesExample = new ArticleCategoriesExample();
		articleCategoriesExample.createCriteria().andCategoriesIdEqualTo(categories.getId());

		// 开始分页
		PageHelper.startPage(pageNum, pageSize);

		List<ArticleCategories > articleCategories = articleCategoriesMapper.selectByExample(articleCategoriesExample);

		List<Article> articles = new ArrayList<>(16);

		for (ArticleCategories item : articleCategories) {
			articles.add(articleMapper.selectByPrimaryKey(item.getArticleId()));
		}

		return articles;
	}
}
