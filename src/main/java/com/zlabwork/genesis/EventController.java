package com.zlabwork.genesis;

import com.zlabwork.genesis.common.EventSource;
import com.zlabwork.genesis.common.SomeEventSource;
import com.zlabwork.genesis.event.MySomeEvent;
import com.zlabwork.genesis.listener.MyEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EventController {

    @Autowired
    private EventSource $eventSource;

    @GetMapping("/events")
    public @ResponseBody
    String events() {

        $eventSource.trigger(new MySomeEvent("TestEvent"));
        return "test event completed";

    }

    @GetMapping("/events/some")
    public @ResponseBody
    String someEvent() {

        // 定义1个事件源
        SomeEventSource source = new SomeEventSource();

        // 定义2个监听器
        MyEventListener listener1 = new MyEventListener("Listener1");
        MyEventListener listener2 = new MyEventListener("Listener2");

        // 注册监听器
        source.addEventListener(listener1);
        source.addEventListener(listener2);

        // 触发事件
        MySomeEvent event = new MySomeEvent("Welcome Joe");
        source.trigger(event);

        // 删除1个监听器
        source.removeEventListener(listener1);

        // 再次触发事件
        event.setMessage("Welcome Alina");
        source.trigger(event);

        return "test event completed";
    }

}