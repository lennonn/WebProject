package com.zlennon.business.mapper;

import com.zlennon.business.model.ArticleType;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface ArticleTypeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleType record);

    ArticleType selectByPrimaryKey(String id);

    List<ArticleType> selectAll();

    int updateByPrimaryKey(ArticleType record);

    int insertBatchSelective(List<ArticleType> records);

    int updateBatchByPrimaryKeySelective(List<ArticleType> records);
}