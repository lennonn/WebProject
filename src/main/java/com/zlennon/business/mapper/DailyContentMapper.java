package com.zlennon.business.mapper;

import com.zlennon.business.model.DailyContent;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface DailyContentMapper {
    int deleteByPrimaryKey(String id);

    int insert(DailyContent record);

    DailyContent selectByPrimaryKey(String id);

    List<DailyContent> selectAll();

    int updateByPrimaryKey(DailyContent record);

    int insertBatchSelective(List<DailyContent> records);

    int updateBatchByPrimaryKeySelective(List<DailyContent> records);

    List<DailyContent> selectByQueryParams(String searchText);
}