package com.pytap.blog.service.impl;

import com.pytap.blog.dao.ViewsMapper;
import com.pytap.blog.model.domain.Views;
import com.pytap.blog.service.ViewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Ecin520
 * @date 2020/5/23 0:43
 */
@Service
public class ViewsServiceImpl implements ViewsService {

	@Resource
	private ViewsMapper viewsMapper;

	@Override
	public Views getViews() {
		return viewsMapper.selectByPrimaryKey(1000L);
	}

	@Override
	public Integer updateViews(Views views) {
		return viewsMapper.updateByPrimaryKey(views);
	}

}
