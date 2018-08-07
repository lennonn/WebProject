package com.zlennon.website.service;
import com.zlennon.Service;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/08/06.
 */
public interface DbTagService<DbTag> extends Service<DbTag> {

    int deleteByPrimaryKey(String id);

    int insert(DbTag dbTag);

    DbTag selectByPrimaryKey(String id);

    List<DbTag> selectAll();

    int updateByPrimaryKey(DbTag dbTag);
}
