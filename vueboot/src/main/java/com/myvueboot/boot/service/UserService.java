package com.myvueboot.boot.service;

import com.myvueboot.boot.entity.LoginTable;

public interface UserService {
    public LoginTable getUser(String username);
}
