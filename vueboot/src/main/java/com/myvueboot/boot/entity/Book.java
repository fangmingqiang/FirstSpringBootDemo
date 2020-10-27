package com.myvueboot.boot.entity;

import lombok.Data;


@Data
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Integer pages;
    private Double price;
}
