package com.myvueboot.boot.controller;

import com.myvueboot.boot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;


    @PostMapping("set")
    public void set(@RequestBody Student student) {
        redisTemplate.opsForValue().set("student", student);
    }

    @GetMapping("/get/{key}")
    public Student get(@PathVariable("key") String key) {
        return (Student) redisTemplate.opsForValue().get(key);
    }

    @DeleteMapping("delete/{key}")
    public boolean delete(@PathVariable("key") String key) {
        redisTemplate.delete(key);
        return redisTemplate.hasKey(key);
    }

    @GetMapping("str/{value}")
    public String setString(@PathVariable("value") String value) {
        redisTemplate.opsForValue().set("str", value);
        return (String) redisTemplate.opsForValue().get("str");
    }

}
