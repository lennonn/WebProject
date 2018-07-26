package com.zlennon.admin.service;
import java.sql.Timestamp;
import java.util.List;
/**
 *
 * Created by zlennon on 2018/07/07.
 */
public interface ImpulseSenderService<ImpulseSender>{
    int deleteByPrimaryKey(String sequenceName);

    int insert(ImpulseSender impulseSender);

    ImpulseSender selectByPrimaryKey(String sequenceName);

    List<ImpulseSender> selectAll();

    int updateByPrimaryKey(ImpulseSender impulseSender);

    int isExists(String sequenceName);

}
