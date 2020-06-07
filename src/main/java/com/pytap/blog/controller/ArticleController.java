package com.pytap.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.blog.model.domain.Article;
import com.pytap.blog.model.dto.ArticleDTO;
import com.pytap.blog.service.ArticleService;
import com.pytap.blog.utils.JsonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/16 1:55
 */
@CrossOrigin
@RestController
public class ArticleController {

	@Resource
	private ArticleService articleService;

	@RequestMapping(value = "/admin/article/insertArticle", method = RequestMethod.POST)
	public JSONObject insertArticle(@RequestBody ArticleDTO articleDTO) {
		return articleService.insertArticle(articleDTO) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/admin/article/deleteArticleById", method = RequestMethod.GET)
	public JSONObject deleteArticleById(Long id) {
		return articleService.deleteArticleById(id) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/admin/article/updateArticle", method = RequestMethod.POST)
	public JSONObject updateArticle(@RequestBody ArticleDTO articleDTO) {
		return articleService.updateArticle(articleDTO) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/article/getArticleById", method = RequestMethod.GET)
	public JSONObject getArticleById(Long id) {
		Article article = articleService.getArticleById(id);
		return JsonUtil.result(articleService.getArticleDto(article));
	}

	@RequestMapping(value = "/article/countArticles", method = RequestMethod.GET)
	public JSONObject countArticles() {
		return JsonUtil.result(articleService.countArticles());
	}

	@RequestMapping(value = "/article/listArticles", method = RequestMethod.GET)
	public JSONObject listArticles(Integer pageNum, Integer pageSize) {
		List<Article> articles = articleService.listArticles(pageNum, pageSize);
		return JsonUtil.result(articleService.listArticleDtosByList(articles));
	}

	@RequestMapping(value = "/article/listRecommendArticles", method = RequestMethod.GET)
	public JSONObject listRecommendArticles() {
		return JsonUtil.result(articleService.listRecommendArticles());
	}

	@RequestMapping(value = "/article/listArticleYears", method = RequestMethod.GET)
	public JSONObject listArticleYears() {
		return JsonUtil.result(articleService.listArticleYears());
	}

	@RequestMapping(value = "/article/listArticleDtosByYear", method = RequestMethod.GET)
	public JSONObject listArticleDtosByYear(Integer pageNum, Integer pageSize, String year) {
		return JsonUtil.result(articleService.listArticleDtosByYear(pageNum, pageSize, year));
	}

	@RequestMapping(value = "/article/countYearArticles", method = RequestMethod.GET)
	public JSONObject countYearArticles(String year) {
		return JsonUtil.result(articleService.countYearArticles(year));
	}



}
