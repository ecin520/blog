package com.pytap.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.blog.model.domain.Article;
import com.pytap.blog.model.domain.ArticleCategories;
import com.pytap.blog.model.domain.Categories;
import com.pytap.blog.service.ArticleCategoriesService;
import com.pytap.blog.service.ArticleService;
import com.pytap.blog.service.CategoriesService;
import com.pytap.blog.utils.JsonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/16 12:25
 */
@CrossOrigin
@RestController
public class CategoriesController {

	@Resource
	private CategoriesService categoriesService;

	@Resource
	private ArticleCategoriesService articleCategoriesService;

	@Resource
	private ArticleService articleService;

	@RequestMapping(value = "/admin/categories/insertCategories", method = RequestMethod.POST)
	public JSONObject insertCategories(@RequestBody Categories categories) {
		return categoriesService.insertCategories(categories) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/admin/categories/deleteCategoriesById", method = RequestMethod.GET)
	public JSONObject deleteCategoriesById(Long id) {
		return categoriesService.deleteCategoriesById(id) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/admin/categories/updateCategories", method = RequestMethod.POST)
	public JSONObject updateCategories(@RequestBody Categories categories) {
		return categoriesService.updateCategories(categories) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/categories/getCategoriesById", method = RequestMethod.GET)
	public JSONObject getCategoriesById(Long id) {
		return JsonUtil.result(categoriesService.getCategoriesById(id));
	}

	@RequestMapping(value = "/categories/getCategoriesByName", method = RequestMethod.GET)
	public JSONObject getCategoriesByName(String name) {
		return JsonUtil.result(categoriesService.getCategoriesByName(name));
	}

	@RequestMapping(value = "/categories/listAllCategories" ,method = RequestMethod.GET)
	public JSONObject listAllCategories() {
		return JsonUtil.result(categoriesService.listAllCategories());
	}

	@RequestMapping(value = "/categories/listAllCategoriesByArticleId" ,method = RequestMethod.GET)
	public JSONObject listAllCategoriesByArticleId(Long id) {
		return JsonUtil.result(articleCategoriesService.listAllCategoriesByArticleId(id));
	}

	@RequestMapping(value = "/admin/categories/insertArticleCategories" ,method = RequestMethod.POST)
	public JSONObject insertArticleCategories(@RequestBody ArticleCategories articleCategories) {
		return articleCategoriesService.insertArticleCategories(articleCategories) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/admin/categories/insertArticleCategoriesList" ,method = RequestMethod.POST)
	public JSONObject insertArticleCategoriesList(@RequestBody List<ArticleCategories> articleCategoriesList) {
		return articleCategoriesService.insertArticleCategoriesList(articleCategoriesList) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/categories/countArticlesByCategoriesName", method = RequestMethod.GET)
	public JSONObject countArticlesByCategoriesName(String name) {
		return JsonUtil.result(articleCategoriesService.countArticlesByCategoriesName(name));
	}

	@RequestMapping(value = "/categories/listArticlesByCategoriesName", method = RequestMethod.GET)
	public JSONObject listArticlesByCategoriesName(Integer pageNum, Integer pageSize, String name) {
		List<Article> articles = articleCategoriesService.listArticlesByCategoriesName(pageNum, pageSize, name);
		return JsonUtil.result(articleService.listArticleDtosByList(articles));

	}

}
