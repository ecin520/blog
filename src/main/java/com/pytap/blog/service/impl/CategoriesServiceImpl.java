package com.pytap.blog.service.impl;

import com.pytap.blog.dao.CategoriesMapper;
import com.pytap.blog.model.domain.Categories;
import com.pytap.blog.model.domain.CategoriesExample;
import com.pytap.blog.service.CategoriesService;
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
public class CategoriesServiceImpl implements CategoriesService {

	@Resource
	private CategoriesMapper categoriesMapper;

	@Override
	public Integer insertCategories(Categories categories) {
		categories.setCreateTime(DateUtil.getDateFormat());
		return categoriesMapper.insert(categories);
	}

	@Override
	public Integer deleteCategoriesById(Long id) {
		return categoriesMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer updateCategories(Categories categories) {
		return categoriesMapper.updateByPrimaryKey(categories);
	}

	@Override
	public Categories getCategoriesById(Long id) {
		return categoriesMapper.selectByPrimaryKey(id);
	}

	@Override
	public Categories getCategoriesByName(String name) {
		CategoriesExample categoriesExample = new CategoriesExample();
		categoriesExample.createCriteria().andNameEqualTo(name);
		return categoriesMapper.selectByExample(categoriesExample).get(0);
	}

	@Override
	public List<Categories> listAllCategories() {
		return categoriesMapper.selectByExample(null);
	}
}
