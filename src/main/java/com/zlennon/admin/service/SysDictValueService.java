package com.zlennon.admin.service;
import com.zlennon.Service;
import com.zlennon.admin.model.SysDictValue;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/10/08.
 */
public interface SysDictValueService<SysDictValue> extends Service<SysDictValue> {

    int deleteByPrimaryKey(String id);

    int insert(SysDictValue sysDictValue);

    SysDictValue selectByPrimaryKey(String id);

    List<SysDictValue> selectAll();

    int updateByPrimaryKey(SysDictValue sysDictValue);

    List<SysDictValue> selectByQueryParams(String searchText, String typeId);

    List<SysDictValue> selectByTypeId(String typeId);
}
