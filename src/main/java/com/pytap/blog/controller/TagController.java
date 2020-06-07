package com.pytap.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.blog.model.domain.Article;
import com.pytap.blog.model.domain.ArticleTag;
import com.pytap.blog.model.domain.Tag;
import com.pytap.blog.service.ArticleService;
import com.pytap.blog.service.ArticleTagService;
import com.pytap.blog.service.TagService;
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
public class TagController {

	@Resource
	private TagService tagService;

	@Resource
	private ArticleService articleService;

	@Resource
	private ArticleTagService articleTagService;

	@RequestMapping(value = "/admin/tag/insertTag", method = RequestMethod.POST)
	public JSONObject insertTag(@RequestBody Tag tag) {
		return tagService.insertTag(tag) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/admin/tag/deleteTagById", method = RequestMethod.GET)
	public JSONObject deleteTagById(Long id) {
		return tagService.deleteTagById(id) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/admin/tag/updateTag", method = RequestMethod.POST)
	public JSONObject updateTag(@RequestBody Tag tag) {
		return tagService.updateTag(tag) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/tag/getTagById", method = RequestMethod.GET)
	public JSONObject getTagById(Long id) {
		return JsonUtil.result(tagService.getTagById(id));
	}

	@RequestMapping(value = "/tag/getTagByName", method = RequestMethod.GET)
	public JSONObject getTagByName(String name) {
		return JsonUtil.result(tagService.getTagByName(name));
	}

	@RequestMapping(value = "/tag/listAllTags", method = RequestMethod.GET)
	public JSONObject listAllTags() {
		return JsonUtil.result(tagService.listAllTags());
	}

	@RequestMapping(value = "/tag/listAllTagsByArticleId", method = RequestMethod.GET)
	public JSONObject listAllTagsByArticleId(Long id) {
		return JsonUtil.result(articleTagService.listAllTagsByArticleId(id));
	}

	@RequestMapping(value = "/admin/tag/insertArticleTag", method = RequestMethod.POST)
	public JSONObject insertArticleTag(@RequestBody ArticleTag articleTag) {
		return articleTagService.insertArticleTag(articleTag) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/admin/tag/insertArticleTagList", method = RequestMethod.POST)
	public JSONObject insertArticleTagList(@RequestBody List<ArticleTag> articleTagList) {
		return articleTagService.insertArticleTagList(articleTagList) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/tag/countArticlesByTagName", method = RequestMethod.GET)
	public JSONObject countArticlesByTagName(String name) {
		return JsonUtil.result(articleTagService.countArticlesByTagName(name));
	}

	@RequestMapping(value = "/tag/listArticlesByTagName", method = RequestMethod.GET)
	public JSONObject listArticlesByTagName(Integer pageNum, Integer pageSize, String name) {
		List<Article> articles = articleTagService.listArticlesByTagName(pageNum, pageSize, name);
		return JsonUtil.result(articleService.listArticleDtosByList(articles));

	}

}
