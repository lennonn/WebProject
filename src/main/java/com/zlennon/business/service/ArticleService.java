package com.zlennon.business.service;

import com.zlennon.Service;
import com.zlennon.business.model.Article;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/09.
 */
public interface ArticleService<Article> extends Service<Article> {

    int deleteByPrimaryKey(String id);

    int insert(Article article);

    Article selectByPrimaryKey(String id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article article);

    List<Article> findByTypeId(String typeId);
}
