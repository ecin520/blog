package com.pytap.blog.service;

import com.pytap.blog.model.domain.Reply;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 22:22
 */
public interface ReplyService {

	/**
	 * 插入回复
	 * @param reply 回复实体
	 * @return Integer 返回结果
	 * */
	Integer insertReply(Reply reply);

	/**
	 * 回复更新
	 * @param reply 回复实体
	 * @return Integer 返回结果
	 * */
	Integer updateReply(Reply reply);

	/**
	 * 获取回复
	 * @param id 回复id
	 * @return Reply 回复传输对象
	 * */
	Reply getReplyById(Long id);

	/**
	 * 获取所有回复
	 * @param id 评论id
	 * @return List<Reply> 返回结果
	 * */
	List<Reply> listAllReplysByCommentId(Long id);

}
