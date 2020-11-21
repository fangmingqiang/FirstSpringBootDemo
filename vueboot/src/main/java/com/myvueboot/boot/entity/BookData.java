package com.myvueboot.boot.entity;

import lombok.Data;

@Data
public class BookData {
    private Integer curPage;

    private Integer pageSize;

    private String token;
}
