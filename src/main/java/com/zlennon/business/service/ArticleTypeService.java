package com.zlennon.business.service;

import com.zlennon.Service;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/09.
 */
public interface ArticleTypeService<ArticleType> extends Service<ArticleType> {

    int deleteByPrimaryKey(String id);

    int insert(ArticleType articleType);

    ArticleType selectByPrimaryKey(String id);

    List<ArticleType> selectAll();

    int updateByPrimaryKey(ArticleType articleType);
}
