package com.myvueboot.boot.security.handler;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.myvueboot.boot.security.exception.ImageCodeException;
import com.myvueboot.boot.security.exception.TokenException;
import com.myvueboot.boot.utils.ResultUtils;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component("loginFailureHandler")
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        //设置响应编码为UTF-8
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //获取输出流
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();

        int code = 500;
        String str = null;
        if (e instanceof AccountExpiredException) {
            str = "账户过期，登陆失败!";
        } else if (e instanceof BadCredentialsException) {
            str = "用户名或者密码错误,登陆失败!";
        } else if (e instanceof DisabledException) {
            str = "账户被禁用,登陆失败";
        } else if (e instanceof LockedException) {
            str = "账户被锁,登陆失败";
        } else if (e instanceof InternalAuthenticationServiceException) {
            str = "账户不存在,登陆失败";
        } else if (e instanceof ImageCodeException) {
            //验证码异常
            str = e.getMessage();
            //Token异常
        } else if (e instanceof TokenException) {
            code = 600;
            str = e.getMessage();
        } else {
            str = "登陆失败!";
        }
        String res = JSONObject.toJSONString(ResultUtils.error(str, code), SerializerFeature.DisableCircularReferenceDetect);
        outputStream.write(res.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
