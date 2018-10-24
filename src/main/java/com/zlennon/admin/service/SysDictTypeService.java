package com.zlennon.admin.service;
import com.zlennon.Service;
import java.util.List;
/**
 *
 * Created by zlennon on 2018/10/08.
 */
public interface SysDictTypeService<SysDictType> extends Service<SysDictType> {

    int deleteByPrimaryKey(String id);

    int insert(SysDictType sysDictType);

    SysDictType selectByPrimaryKey(String id);

    List<SysDictType> selectAll();

    int updateByPrimaryKey(SysDictType sysDictType);

    List<SysDictType> selectByQueryParams(String searchText);

}
