package com.zlabwork.genesis.common;


import com.zlabwork.genesis.listener.EventListenerInterface;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class MyEventSource {

    // 监听器集合
    private List<EventListenerInterface> listeners = new ArrayList<>();

    // 添加监听器
    public void addEventListener(EventListenerInterface listener) {
        listeners.add(listener);
    }

    // 移除监听器
    public void removeEventListener(EventListenerInterface listener) {
        listeners.remove(listener);
    }

    // 触发事件通知所有监听器
    public void trigger(EventObject event) {
        for (EventListenerInterface listener : listeners) {
            listener.handle(event);
        }
    }

}
