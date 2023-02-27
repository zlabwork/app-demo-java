package com.zlabwork.genesis.listener;


import com.zlabwork.genesis.event.MySomeEvent;

import java.util.EventObject;

public class MyEventListener implements EventListenerInterface {

    private String name;

    public MyEventListener(String name) {
        this.name = name;
    }

    public void handle(EventObject event) {
        MySomeEvent ev = (MySomeEvent) event;
        System.out.println(this.name + " Received Message: " + ev.getMessage());
    }
}
