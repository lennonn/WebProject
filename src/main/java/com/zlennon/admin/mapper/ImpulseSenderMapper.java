package com.zlennon.admin.mapper;

import com.zlennon.admin.model.ImpulseSender;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface ImpulseSenderMapper {
    int deleteByPrimaryKey(String sequenceName);

    int insert(ImpulseSender record);

    ImpulseSender selectByPrimaryKey(String sequenceName);

    List<ImpulseSender> selectAll();

    int updateByPrimaryKey(ImpulseSender record);

    int insertBatchSelective(List<ImpulseSender> records);

    int updateBatchByPrimaryKeySelective(List<ImpulseSender> records);

    int isExistsSequence(String sequenceName);

}