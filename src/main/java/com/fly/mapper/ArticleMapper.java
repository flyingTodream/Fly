package com.fly.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fly.model.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String id);

    List<Article> selectList(Article record);
    
    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    List<Article> search(@Param("kw")String kw);
}