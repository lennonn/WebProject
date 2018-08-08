package com.zlennon.website.service;
import com.zlennon.Service;

import java.util.List;
import java.util.Map;

/**
 *
 * Created by zlennon on 2018/08/06.
 */
public interface DbTagListService<DbTagList> extends Service<DbTagList> {

    int deleteByPrimaryKey(String id);

    int insert(DbTagList dbTagList);

    DbTagList selectByPrimaryKey(String id);

    List<DbTagList> selectAll();

    int updateByPrimaryKey(DbTagList dbTagList);

    List<Map<Float,Long>> group();

    List<DbTagList> selectByStar(Float star);
}
