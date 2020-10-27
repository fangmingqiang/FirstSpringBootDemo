package com.myvueboot.boot.controller;

import com.myvueboot.boot.entity.Book;
import com.myvueboot.boot.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookShowController {
    @Autowired
    private BookMapper bookMapper;

    @GetMapping("all/{curPage}/{pageSize}")
    public List<Book> findAll(@PathVariable("curPage") Integer curPage, @PathVariable("pageSize") Integer pageSize){
        System.out.println(bookMapper.getAll(curPage, pageSize));
        return bookMapper.getAll(curPage, pageSize);
    }

    @GetMapping("count")
    public Integer getPageNumber(){
        System.out.println(bookMapper.getCount());
        return bookMapper.getCount();
    }


}
