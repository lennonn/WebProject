package com.zlennon.admin.mapper;

import com.zlennon.admin.model.PageView;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;

@MapperScan
@Repository
public interface PageViewMapper {
    int deleteByPrimaryKey(String id);

    int insert(PageView record);

    PageView selectByPrimaryKey(String id);

    List<PageView> selectAll();

    int updateByPrimaryKey(PageView record);

    int insertBatchSelective(List<PageView> records);

    int updateBatchByPrimaryKeySelective(List<PageView> records);
}