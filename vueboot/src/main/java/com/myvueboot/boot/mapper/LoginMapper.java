package com.myvueboot.boot.mapper;

import com.myvueboot.boot.entity.LoginTable;
import com.myvueboot.boot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginMapper {
    @Select("select * from logintable where username = #{username} and password = #{password}")
    public LoginTable login(User user);
}
