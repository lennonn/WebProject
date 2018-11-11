package com.zlennon.business.service;
import com.zlennon.Service;
import com.zlennon.business.model.DailyContent;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/10/08.
 */
public interface DailyContentService<DailyContent> extends Service<DailyContent> {

    int deleteByPrimaryKey(String id);

    int insert(DailyContent dailyContent);

    DailyContent selectByPrimaryKey(String id);

    List<DailyContent> selectAll();

    int updateByPrimaryKey(DailyContent dailyContent);

    List<DailyContent> selectByQueryParams(String searchText);

    List<DailyContent> selectByType(String s);
}
