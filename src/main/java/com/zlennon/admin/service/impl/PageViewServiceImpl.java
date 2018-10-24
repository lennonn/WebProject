package com.zlennon.admin.service.impl;

import com.zlennon.admin.mapper.PageViewMapper;
import com.zlennon.admin.model.PageView;
import com.zlennon.admin.service.PageViewService;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/09/20.
 */
@Service
public class PageViewServiceImpl extends AbstractService<PageView> implements PageViewService<PageView> {

    @Autowired
    private PageViewMapper pageViewMapper;

    public PageViewMapper getPageViewMapper() {
        return pageViewMapper;
    }

    public void setPageViewMapper(PageViewMapper pageViewMapper) {
        this.pageViewMapper = pageViewMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  pageViewMapper.deleteByPrimaryKey(id);
    }

    public int insert(PageView pageView){
        pageView.setId(getTablePK("PageView"));
       return pageViewMapper.insert(pageView);
    }

    public PageView selectByPrimaryKey(String id){
       return  pageViewMapper.selectByPrimaryKey(id);
    }

    public List<PageView> selectAll(){
       return pageViewMapper.selectAll();
    }

    public int updateByPrimaryKey(PageView pageView){
       return pageViewMapper.updateByPrimaryKey(pageView);
    }
}
