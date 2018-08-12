package com.zlennon.business.service.impl;

import com.zlennon.AbstractService;
import com.zlennon.business.mapper.ArticleMapper;
import com.zlennon.business.model.Article;
import com.zlennon.business.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/09.
 */
@Service
public class ArticleServiceImpl extends AbstractService<Article> implements ArticleService<Article> {

    @Autowired
    private ArticleMapper articleMapper;

    public ArticleMapper getArticleMapper() {
        return articleMapper;
    }

    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  articleMapper.deleteByPrimaryKey(id);
    }

    public int insert(Article article){
        article.setId(getTablePK("Article"));
        article.setTime(new Date());
        article.setAuthor("zlennon");
       return articleMapper.insert(article);
    }

    public Article selectByPrimaryKey(String id){
       return  articleMapper.selectByPrimaryKey(id);
    }

    public List<Article> selectAll(){
       return articleMapper.selectAll();
    }

    public int updateByPrimaryKey(Article article){
       return articleMapper.updateByPrimaryKey(article);
    }
}
