package com.pytap.blog.service;

import com.pytap.blog.model.domain.Comment;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 22:18
 */
public interface CommentService {

	/**
	 * 插入评论
	 * @param comment 评论实体
	 * @return Integer 返回结果
	 * */
	Integer insertComment(Comment comment);

	/**
	 * 主键删除评论
	 * @param id 主键
	 * @return Integer 返回结果
	 * */
	Integer deleteCommentById(Long id);

	/**
	 * 评论更新
	 * @param comment 评论实体
	 * @return Integer 返回结果
	 * */
	Integer updateComment(Comment comment);

	/**
	 * 获取评论
	 * @param id 评论id
	 * @return Comment 评论
	 * */
	Comment getCommentById(Long id);

	/**
	 * 获取所有评论
	 * @param id 文章id
	 * @return List<Comment> 返回结果
	 * */
	List<Comment> listAllCommentsByArticleId(Long id);

}
