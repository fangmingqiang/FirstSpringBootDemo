package com.myvueboot.boot.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Test
    void findAll() {
        System.out.println(bookMapper.getAll(0, 5));
    }

    @Test
    void passsEncode(){
        System.out.println(passwordEncoder.encode("123456"));

    }


}