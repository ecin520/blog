package com.pytap.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.pytap.blog.model.domain.Reply;
import com.pytap.blog.service.ReplyService;
import com.pytap.blog.utils.JsonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/5/16 16:57
 */
@CrossOrigin
@RestController
public class ReplyController {

	@Resource
	private ReplyService replyService;

	@RequestMapping(value = "/reply/insertReply", method = RequestMethod.POST)
	public JSONObject insertReply(@RequestBody Reply reply) {
		return replyService.insertReply(reply) == 1 ? JsonUtil.success() : JsonUtil.fail();
	}

	@RequestMapping(value = "/reply/listAllReplysByCommentId", method = RequestMethod.GET)
	public JSONObject listAllReplysByCommentId(Long id) {
		return JsonUtil.result(replyService.listAllReplysByCommentId(id));
	}

}
