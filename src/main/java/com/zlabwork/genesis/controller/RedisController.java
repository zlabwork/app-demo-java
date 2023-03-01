package com.zlabwork.genesis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@Controller
@RequestMapping(path = "/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping(path = "/index")
    @ResponseBody
    public String indexPage() {

        Set<String> data = stringRedisTemplate.opsForZSet().range("TEST_KEY:123456", 0, -1);
        System.out.println(data);

        return "this is redis test page";
    }

}
