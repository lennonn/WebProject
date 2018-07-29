package com.zlennon.website.service;

import com.zlennon.Service;

import java.util.List;
/**
 *
 * Created by zlennon on 2018/07/28.
 */
public interface BookService<Book> extends Service<Book> {

    int deleteByPrimaryKey(String id);

    int insert(Book book);

    Book selectByPrimaryKey(String id);

    List<Book> selectAll();

    int updateByPrimaryKey(Book book);
}
