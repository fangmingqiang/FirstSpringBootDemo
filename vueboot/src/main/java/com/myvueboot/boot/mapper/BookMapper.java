package com.myvueboot.boot.mapper;

import com.myvueboot.boot.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookMapper {
    @Select("select id,name,author,publish,pages,price from Book limit #{curPage},#{pageSize}")
    public List<Book> getAll(Integer curPage, Integer pageSize);

    @Select("select count(*) from Book")
    public Integer getCount();
}
