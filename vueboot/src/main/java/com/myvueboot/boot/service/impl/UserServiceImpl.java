package com.myvueboot.boot.service.impl;

import com.myvueboot.boot.entity.LoginTable;
import com.myvueboot.boot.mapper.LoginMapper;
import com.myvueboot.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginTable getUser(String username) {
        return loginMapper.getUser(username);
    }
}
