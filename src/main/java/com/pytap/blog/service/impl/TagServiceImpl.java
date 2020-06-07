package com.pytap.blog.service.impl;

import com.pytap.blog.dao.TagMapper;
import com.pytap.blog.model.domain.Tag;
import com.pytap.blog.model.domain.TagExample;
import com.pytap.blog.service.TagService;
import com.pytap.blog.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 23:16
 */
@Service
public class TagServiceImpl implements TagService {

	@Resource
	private TagMapper tagMapper;

	@Override
	public Integer insertTag(Tag tag) {
		tag.setCreateTime(DateUtil.getDateFormat());
		return tagMapper.insert(tag);
	}

	@Override
	public Integer deleteTagById(Long id) {
		return tagMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateTag(Tag tag) {
		return tagMapper.updateByPrimaryKey(tag);
	}

	@Override
	public Tag getTagById(Long id) {
		return tagMapper.selectByPrimaryKey(id);
	}

	@Override
	public Tag getTagByName(String name) {
		TagExample tagExample = new TagExample();
		tagExample.createCriteria().andNameEqualTo(name);
		List<Tag> list = tagMapper.selectByExample(tagExample);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<Tag> listAllTags() {
		return tagMapper.selectByExample(null);
	}
}
