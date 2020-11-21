package com.myvueboot.boot.result;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultVo<T> {
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回的数据
     */
    private T data;
}
