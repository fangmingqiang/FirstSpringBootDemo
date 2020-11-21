package com.myvueboot.boot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myvueboot.boot.utils.ValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.google.code.kaptcha.impl.DefaultKaptcha;

@Controller
public class KaptchaControler {
    @Autowired
    private ValidateCodeUtils validateCodeUtils;

    @Resource
    private DefaultKaptcha captchaProducer;

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 登录验证码SessionKey
     */
    public static final String LOGIN_VALIDATE_CODE = "login_validate_code";

    /**
     * 登录验证码图片
     */
    @RequestMapping(value = {"/loginValidateCode/**"})
    public void loginValidateCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        validateCodeUtils.validateCode(request, response, captchaProducer, LOGIN_VALIDATE_CODE);
    }

    /**
     * 检查验证码是否正确
     */
    @RequestMapping(value = {"/checkLoginValidateCode"})
    @ResponseBody
    public HashMap checkLoginValidateCode(HttpServletRequest request, @RequestBody Map<String, String> validateCode) {
        System.out.println(validateCode.get("validateCode"));
//        String loginValidateCode = request.getSession().getAttribute(LOGIN_VALIDATE_CODE).toString();
        String loginValidateCode = (String) redisTemplate.opsForValue().get(LOGIN_VALIDATE_CODE);
        System.out.println(loginValidateCode);
        HashMap<String, Object> map = new HashMap<String, Object>();
        if (loginValidateCode == null) {
            map.put("status", null);//验证码过期
        } else if (loginValidateCode.equals(validateCode.get("validateCode"))) {
            map.put("status", true);//验证码正确
        } else {
            map.put("status", false);//验证码不正确
        }
        map.put("code", 200);
        return map;
    }
}