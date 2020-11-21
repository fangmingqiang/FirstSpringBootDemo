package com.myvueboot.boot.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Token验证失败异常
 */
public class TokenException extends AuthenticationException {
    public TokenException(String msg) {
        super(msg);
    }
}
