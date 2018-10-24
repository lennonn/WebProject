package com.zlennon.business.service.impl;

import com.zlennon.business.mapper.DailyContentMapper;
import com.zlennon.business.model.DailyContent;
import com.zlennon.business.service.DailyContentService;
import com.zlennon.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/10/08.
 */
@Service
public class DailyContentServiceImpl extends AbstractService<DailyContent> implements DailyContentService<DailyContent> {

    @Autowired
    private DailyContentMapper dailyContentMapper;

    public DailyContentMapper getDailyContentMapper() {
        return dailyContentMapper;
    }

    public void setDailyContentMapper(DailyContentMapper dailyContentMapper) {
        this.dailyContentMapper = dailyContentMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  dailyContentMapper.deleteByPrimaryKey(id);
    }

    public int insert(DailyContent dailyContent){
        dailyContent.setId(getTablePK("DailyContent"));
       return dailyContentMapper.insert(dailyContent);
    }

    public DailyContent selectByPrimaryKey(String id){
       return  dailyContentMapper.selectByPrimaryKey(id);
    }

    public List<DailyContent> selectAll(){
       return dailyContentMapper.selectAll();
    }

    public int updateByPrimaryKey(DailyContent dailyContent){
       return dailyContentMapper.updateByPrimaryKey(dailyContent);
    }

    @Override
    public List<DailyContent> selectByQueryParams(String searchText) {
       return dailyContentMapper.selectByQueryParams(searchText);
    }
}
