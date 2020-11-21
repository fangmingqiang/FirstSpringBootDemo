package com.myvueboot.boot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FindName {

    @Select("select username from logintable where username = #{username}")
    public String findName(String username);
}
