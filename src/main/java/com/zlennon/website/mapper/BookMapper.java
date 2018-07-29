package com.zlennon.website.mapper;

import com.zlennon.website.model.Book;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;;import javax.annotation.Resource;

@MapperScan
@Repository
public interface BookMapper {
    int deleteByPrimaryKey(String id);

    int insert(Book record);

    Book selectByPrimaryKey(String id);

    List<Book> selectAll();

    int updateByPrimaryKey(Book record);

    int insertBatchSelective(List<Book> records);

    int updateBatchByPrimaryKeySelective(List<Book> records);
}