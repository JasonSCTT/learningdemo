package com.jason.bookstore;

import com.jason.mapper.BookMapper;
import com.jason.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookMapper bookmapper;



    public List<Book> getAllBooks(){
        return bookmapper.getAllBook();
    }

    public Book getBookById(int id){
        return bookmapper
                .getBookById(id);
    }



    public int add(Book entity) throws Exception {
        if(entity.getTitle()
                ==null || entity.getTitle().equals("")){

            throw  new Exception("书名不能为空");
        }
        return bookmapper.add(entity);
    }

    @Transactional
    public  int add(Book entity1,Book entityBak){
        int rows =0;
        rows=bookmapper.add(entity1);
        rows=bookmapper.add(entityBak);
        return  rows;
    }


    public  int delete(int id){
        return  bookmapper.delete(id);
    }


    public  int delete(String [] ids){

        int rows =0;

        for(String idStr : ids){
            int id =Integer.parseInt(idStr);
            rows+=delete(id);
        }
        return  rows;
    }

    public  int update(Book entity){
        return bookmapper.update(entity);
    }




}
