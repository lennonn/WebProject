package com.zlennon.website.service.impl;

import com.zlennon.AbstractService;
import com.zlennon.website.mapper.BookMapper;
import com.zlennon.website.model.Book;
import com.zlennon.website.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/07/28.
 */
@Service
public class BookServiceImpl extends AbstractService<Book> implements BookService<Book> {

    @Autowired
    private BookMapper bookMapper;

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int deleteByPrimaryKey(String id){
      return  bookMapper.deleteByPrimaryKey(id);
    }

    public int insert(Book book){
       return bookMapper.insert(book);
    }

    public Book selectByPrimaryKey(String id){
       return  bookMapper.selectByPrimaryKey(id);
    }

    public List<Book> selectAll(){
       return bookMapper.selectAll();
    }

    public int updateByPrimaryKey(Book book){
       return bookMapper.updateByPrimaryKey(book);
    }
}
