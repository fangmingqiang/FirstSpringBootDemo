package com.myvueboot.boot.security.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * 验证码验证失败异常
 */
public class ImageCodeException extends AuthenticationException {
    public ImageCodeException(String msg) {
        super(msg);
    }
}
