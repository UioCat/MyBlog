package com.hanxun.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alfred
 * @Description: 用户controller
 * @time 2021/7/16 14:15
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @RequestMapping("/test")
    public void testRedis(){

    }
}
