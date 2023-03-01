package com.zlabwork.genesis.controller;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import com.zlabwork.genesis.entity.UserEntity;
import com.zlabwork.genesis.message.ResultFormat;
import com.zlabwork.genesis.message.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class VersionController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/version")
    public Version version(@RequestParam(value = "name", defaultValue = "World") String name) {

        // 日志
        Logger logger = LoggerFactory.getLogger(VersionController.class);
        logger.info("Hello World");

        // 打印
        System.out.println("this text output");

        return new Version(counter.incrementAndGet(), "success", String.format(template, name));
    }

    @RequestMapping("/result")
    public ResultFormat<UserEntity> resultMethod() {

        UserEntity user = new UserEntity();
        user.setId(1000);
        user.setName("Alina");
        user.setEmail("alina@xxtime.com");
        user.setDate(new Date());
        return ResultFormat.success(user, "it is ok");
    }

}
