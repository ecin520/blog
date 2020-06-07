package com.pytap.blog.dao;

import com.pytap.blog.model.domain.Views;
import com.pytap.blog.model.domain.ViewsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ViewsMapper {
    long countByExample(ViewsExample example);

    int deleteByExample(ViewsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Views record);

    int insertSelective(Views record);

    List<Views> selectByExample(ViewsExample example);

    Views selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Views record, @Param("example") ViewsExample example);

    int updateByExample(@Param("record") Views record, @Param("example") ViewsExample example);

    int updateByPrimaryKeySelective(Views record);

    int updateByPrimaryKey(Views record);
}