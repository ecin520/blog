package com.pytap.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.blog.model.domain.Comment;
import com.pytap.blog.service.CommentService;
import com.pytap.blog.utils.JsonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/5/16 13:40
 */
@CrossOrigin
@RestController
public class CommentController {

	@Resource
	private CommentService commentService;

	@RequestMapping(value = "/comment/insertComment", method = RequestMethod.POST)
	public JSONObject insertComment(@RequestBody Comment comment) {
		return commentService.insertComment(comment) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/admin/comment/deleteCommentById", method = RequestMethod.GET)
	public JSONObject insertComment(Long id) {
		return commentService.deleteCommentById(id) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/comment/getCommentById", method = RequestMethod.GET)
	public JSONObject getCommentById(Long id) {
		return JsonUtil.result(commentService.getCommentById(id));
	}

	@RequestMapping(value = "/comment/listAllCommentsByArticleId", method = RequestMethod.GET)
	public JSONObject listAllCommentsByArticleId(Long id) {
		return JsonUtil.result(commentService.listAllCommentsByArticleId(id));
	}

}
