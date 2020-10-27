package com.myvueboot.boot.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;
    @Test
    void findAll(){
        System.out.println(bookMapper.getAll(0,5));
    }

}