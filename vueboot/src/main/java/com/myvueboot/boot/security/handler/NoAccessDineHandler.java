package com.myvueboot.boot.security.handler;

import com.alibaba.fastjson.JSONObject;
import com.myvueboot.boot.status.StatusCode;
import com.myvueboot.boot.utils.ResultUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component("noAccessDineHandler")
public class NoAccessDineHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        //获得响应输出流
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        //构建传输到前端的JSON数据
        String res = JSONObject.toJSONString(ResultUtils.error("未登录，无权限访问", StatusCode.NO_AUTH));
        outputStream.write(res.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
        outputStream.close();
    }
}
