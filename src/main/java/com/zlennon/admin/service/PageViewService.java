package com.zlennon.admin.service;
import com.zlennon.Service;
import java.util.List;
/**
 *
 * Created by zlennon on 2018/09/20.
 */
public interface PageViewService<PageView> extends Service<PageView> {

    int deleteByPrimaryKey(String id);

    int insert(PageView pageView);

    PageView selectByPrimaryKey(String id);

    List<PageView> selectAll();

    int updateByPrimaryKey(PageView pageView);
}
