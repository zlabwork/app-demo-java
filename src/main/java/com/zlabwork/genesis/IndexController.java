package com.zlabwork.genesis;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import com.zlabwork.genesis.entity.UserEntity;
import com.zlabwork.genesis.message.CommonResult;
import com.zlabwork.genesis.message.Version;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class IndexController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public Version index(@RequestParam(value = "name", defaultValue = "World") String name) {

        System.out.println("this text output");

        return new Version(counter.incrementAndGet(), "success", String.format(template, name));
    }

    @RequestMapping("/result")
    public CommonResult<UserEntity> resultMethod() {

        UserEntity user = new UserEntity();
        user.setId(1000);
        user.setName("Alina");
        user.setEmail("alina@xxtime.com");
        user.setDate(new Date());
        return CommonResult.success(user, "it is ok");
    }

}
