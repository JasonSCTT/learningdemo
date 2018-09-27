package com.jason.mapper;

import com.jason.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    /**
     * 获取所有的书本
     */
    List<Book> getAllBook();


    /**
     * 根据图书编号获取图书对象
     * @param id
     */
    Book getBookById(@Param("id") int id);



    /**
     * 添加图书
     */
    public int add(Book entity);

    /**
     * 根据图书编号删除图书
     */

    public int delete(int id);
    /**
     * 更新图书
     */
    public int update(Book entity);








}
