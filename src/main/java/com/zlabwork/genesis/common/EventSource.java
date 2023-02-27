package com.zlabwork.genesis.common;


import com.zlabwork.genesis.event.MySomeEvent;
import com.zlabwork.genesis.listener.EventListenerInterface;
import com.zlabwork.genesis.listener.MyEventListener;

import java.util.*;

public class EventSource {


    // 事件与监听器映射
    // private Map<String, List<EventListenerInterface>> eventMaps = new HashMap<>() {{
    //     put((new MySomeEvent("TestEvent")).toString(), new ArrayList<>() {{
    //         add(new MyEventListener("ListenerA"));
    //         add(new MyEventListener("ListenerB"));
    //     }});
    // }};
    private Map<String, List<EventListenerInterface>> eventMaps = new HashMap<>();

    public void setEventMaps(Map<String, List<EventListenerInterface>> value) {
        this.eventMaps = value;
    }

    // 触发
    public void trigger(EventObject event) {
        List<EventListenerInterface> listeners = eventMaps.get(event.toString());
        if (listeners == null) {
            System.out.println("can not find listeners with key: " + event.toString());
            return;
        }
        for (EventListenerInterface listener : listeners) {
            listener.handle(event);
        }
    }

}
