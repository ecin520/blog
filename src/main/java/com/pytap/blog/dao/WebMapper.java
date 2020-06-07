package com.pytap.blog.dao;

import com.pytap.blog.model.dto.SearchDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Ecin520
 * @date 2020/5/23 11:03
 */
@Mapper
public interface WebMapper {

	/**
	 * 获取搜索传输对象
	 * @return List<SearchDTO>
	 * */
	List<SearchDTO> selectAllValues();

}
