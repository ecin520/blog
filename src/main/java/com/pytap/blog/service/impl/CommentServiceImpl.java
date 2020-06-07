package com.pytap.blog.service.impl;

import com.pytap.blog.dao.CommentMapper;
import com.pytap.blog.model.domain.Comment;
import com.pytap.blog.model.domain.CommentExample;
import com.pytap.blog.service.CommentService;
import com.pytap.blog.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 23:14
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentMapper commentMapper;

	@Override
	public Integer insertComment(Comment comment) {
		comment.setCreateTime(DateUtil.getDateFormat());
		return commentMapper.insert(comment);
	}

	@Override
	public Integer deleteCommentById(Long id) {
		return commentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateComment(Comment comment) {
		return commentMapper.updateByPrimaryKey(comment);
	}

	@Override
	public Comment getCommentById(Long id) {
		return commentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Comment> listAllCommentsByArticleId(Long id) {
		CommentExample commentExample = new CommentExample();
		commentExample.createCriteria().andArticleIdEqualTo(id);
		commentExample.setOrderByClause("create_time ASC");
		return commentMapper.selectByExample(commentExample);
	}
}
