package com.myvueboot.boot.controller;

import com.myvueboot.boot.entity.Book;
import com.myvueboot.boot.entity.BookData;
import com.myvueboot.boot.jwt.JwtTokenProvider;
import com.myvueboot.boot.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookShowController {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("all")
    public List<Book> findAll(@RequestBody BookData bookData) {
        System.out.println(bookData.getCurPage());
        System.out.println(bookData.getPageSize());
        System.out.println(bookData.getToken());
        if (jwtTokenProvider.validateToken(bookData.getToken())){
            return bookMapper.getAll(bookData.getCurPage(), bookData.getPageSize());
        }else {
            return null;
        }

    }

    @GetMapping("count")
    public Integer getPageNumber() {
        return bookMapper.getCount();
    }

}
