package com.myvueboot.boot.controller;

import com.myvueboot.boot.entity.LoginTable;
import com.myvueboot.boot.entity.User;
import com.myvueboot.boot.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginMapper loginMapper;

    @PostMapping("go")
    public boolean login(@RequestBody User user){
        if (loginMapper.login(user) != null){
            return true;
        }
        return false;
    }

}
