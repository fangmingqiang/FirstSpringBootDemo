package com.myvueboot.boot.security;

import com.myvueboot.boot.entity.LoginTable;
import com.myvueboot.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("customUserDetailsService")
public class BookUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LoginTable user = userService.getUser(s);
        if (user == null) {
            throw new UsernameNotFoundException("此用户不存在!");
        }
        return user;
    }

}
