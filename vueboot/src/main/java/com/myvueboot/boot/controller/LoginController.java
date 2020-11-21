package com.myvueboot.boot.controller;

import com.myvueboot.boot.entity.User;
import com.myvueboot.boot.jwt.JwtAuthenticationResponse;
import com.myvueboot.boot.jwt.JwtTokenProvider;
import com.myvueboot.boot.mapper.LoginMapper;
import com.myvueboot.boot.utils.RsaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    //读取配置文件的私钥
    @Value("${rsa.private_key}")
    private String privateKey;

    @PostMapping("go")
    public ResponseEntity<?> login(@RequestBody User user) {
        System.out.println(user.getPassword());
        //RSA解密前端传过来的密码
        try {
            user.setPassword(RsaUtils.decryptByPrivateKey(privateKey, user.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);


        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));


//        System.out.println(user.getPassword());
//        return loginMapper.login(user) != null;
    }

}
