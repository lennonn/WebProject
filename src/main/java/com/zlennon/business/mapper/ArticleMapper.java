package com.zlennon.business.mapper;

import com.zlennon.business.model.Article;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Article record);

    Article selectByPrimaryKey(String id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);

    int insertBatchSelective(List<Article> records);

    int updateBatchByPrimaryKeySelective(List<Article> records);

    List<Article> findByTypeId(String typeId);
}