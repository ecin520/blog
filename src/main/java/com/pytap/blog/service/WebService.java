package com.pytap.blog.service;

import com.pytap.blog.model.dto.SearchDTO;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/23 11:06
 */
public interface WebService {

	/**
	 * 获取搜索传输对象
	 * @return List<SearchDTO>
	 * */
	List<SearchDTO> selectAllValues();

}
