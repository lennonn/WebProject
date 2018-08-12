package com.zlennon.business.service.impl;

import com.zlennon.AbstractService;
import com.zlennon.business.mapper.ArticleTypeMapper;
import com.zlennon.business.model.ArticleType;
import com.zlennon.business.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/09.
 */
@Service
public class ArticleTypeServiceImpl extends AbstractService<ArticleType> implements ArticleTypeService<ArticleType> {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    public ArticleTypeMapper getArticleTypeMapper() {
        return articleTypeMapper;
    }

    public void setArticleTypeMapper(ArticleTypeMapper articleTypeMapper) {
        this.articleTypeMapper = articleTypeMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  articleTypeMapper.deleteByPrimaryKey(id);
    }

    public int insert(ArticleType articleType){
        articleType.setId(getTablePK("ArticleType"));
       return articleTypeMapper.insert(articleType);
    }

    public ArticleType selectByPrimaryKey(String id){
       return  articleTypeMapper.selectByPrimaryKey(id);
    }

    public List<ArticleType> selectAll(){
       return articleTypeMapper.selectAll();
    }

    public int updateByPrimaryKey(ArticleType articleType){
       return articleTypeMapper.updateByPrimaryKey(articleType);
    }
}
