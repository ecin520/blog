package com.pytap.blog.service.impl;

import com.pytap.blog.dao.WebMapper;
import com.pytap.blog.model.dto.SearchDTO;
import com.pytap.blog.service.WebService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/23 11:08
 */
@Service
public class WebServiceImpl implements WebService {

	@Resource
	private WebMapper webMapper;

	@Override
	public List<SearchDTO> selectAllValues() {
		return webMapper.selectAllValues();
	}

}
