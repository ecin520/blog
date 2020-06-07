package com.pytap.blog.service.impl;

import com.pytap.blog.dao.ReplyMapper;
import com.pytap.blog.model.domain.Reply;
import com.pytap.blog.model.domain.ReplyExample;
import com.pytap.blog.service.ReplyService;
import com.pytap.blog.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 23:15
 */
@Service
public class ReplyServiceImpl implements ReplyService {

	@Resource
	private ReplyMapper replyMapper;

	@Override
	public Integer insertReply(Reply reply) {
		reply.setCreateTime(DateUtil.getDateFormat());
		return replyMapper.insert(reply);
	}

	@Override
	public Integer updateReply(Reply reply) {
		return replyMapper.updateByPrimaryKey(reply);
	}

	@Override
	public Reply getReplyById(Long id) {
		return replyMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Reply> listAllReplysByCommentId(Long id) {
		ReplyExample replyExample = new ReplyExample();
		replyExample.createCriteria().andCommentIdEqualTo(id);
		replyExample.setOrderByClause("create_time ASC");
		return replyMapper.selectByExample(replyExample);
	}
}
