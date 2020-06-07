package com.pytap.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.pytap.blog.dao.ArticleMapper;
import com.pytap.blog.dao.ArticleTagMapper;
import com.pytap.blog.dao.TagMapper;
import com.pytap.blog.model.domain.*;
import com.pytap.blog.service.ArticleTagService;
import com.pytap.blog.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/15 21:53
 */
@Service
public class ArticleTagServiceImpl implements ArticleTagService {

	@Resource
	private ArticleTagMapper articleTagMapper;

	@Resource
	private ArticleMapper articleMapper;

	@Resource
	private TagMapper tagMapper;

	@Override
	public Integer insertArticleTag(ArticleTag articleTag) {
		articleTag.setCreateTime(DateUtil.getDateFormat());
		return articleTagMapper.insert(articleTag);
	}

	@Override
	public Integer insertArticleTagList(List<ArticleTag> articleTagList) {
		for (ArticleTag item : articleTagList) {
			item.setCreateTime(DateUtil.getDateFormat());
			articleTagMapper.insert(item);
		}
		return 1;
	}

	@Override
	public Integer deleteArticleTagById(Long id) {
		return articleTagMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateArticleTag(ArticleTag articleTag) {
		return articleTagMapper.updateByPrimaryKey(articleTag);
	}

	@Override
	public List<Tag> listAllTagsByArticleId(Long id) {
		ArticleTagExample articleTagExample = new ArticleTagExample();
		articleTagExample.createCriteria().andArticleIdEqualTo(id);
		List<ArticleTag> articleTags = articleTagMapper.selectByExample(articleTagExample);
		List<Tag> tags = new ArrayList<>(16);
		for (ArticleTag articleTag : articleTags) {
			tags.add(tagMapper.selectByPrimaryKey(articleTag.getTagId()));
		}
		return tags;
	}

	@Override
	public Long countArticlesByTagName(String name) {

		// 获取标签id
		TagExample tagExample = new TagExample();
		tagExample.createCriteria().andNameEqualTo(name);
		Tag tag = tagMapper.selectByExample(tagExample).get(0);

		// 通过标签id获取文章Example
		ArticleTagExample articleTagExample = new ArticleTagExample();
		articleTagExample.createCriteria().andTagIdEqualTo(tag.getId());

		return articleTagMapper.countByExample(articleTagExample);
	}

	@Override
	public List<Article> listArticlesByTagName(Integer pageNum, Integer pageSize, String name) {

		// 获取标签id
		TagExample tagExample = new TagExample();
		tagExample.createCriteria().andNameEqualTo(name);
		Tag tag = tagMapper.selectByExample(tagExample).get(0);

		// 通过标签id获取所有文章id
		ArticleTagExample articleTagExample = new ArticleTagExample();
		articleTagExample.createCriteria().andTagIdEqualTo(tag.getId());

		// 开始分页
		PageHelper.startPage(pageNum, pageSize);

		List<ArticleTag > articleTag = articleTagMapper.selectByExample(articleTagExample);

		List<Article> articles = new ArrayList<>(16);

		for (ArticleTag item : articleTag) {
			articles.add(articleMapper.selectByPrimaryKey(item.getArticleId()));
		}

		return articles;
	}
}
