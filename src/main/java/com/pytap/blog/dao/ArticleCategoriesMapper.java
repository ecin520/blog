package com.pytap.blog.dao;

import com.pytap.blog.model.domain.ArticleCategories;
import com.pytap.blog.model.domain.ArticleCategoriesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleCategoriesMapper {
    long countByExample(ArticleCategoriesExample example);

    int deleteByExample(ArticleCategoriesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleCategories record);

    int insertSelective(ArticleCategories record);

    List<ArticleCategories> selectByExample(ArticleCategoriesExample example);

    ArticleCategories selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleCategories record, @Param("example") ArticleCategoriesExample example);

    int updateByExample(@Param("record") ArticleCategories record, @Param("example") ArticleCategoriesExample example);

    int updateByPrimaryKeySelective(ArticleCategories record);

    int updateByPrimaryKey(ArticleCategories record);
}