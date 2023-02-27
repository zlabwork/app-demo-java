package com.zlabwork.genesis.listener;


import java.util.EventListener;
import java.util.EventObject;

public interface EventListenerInterface extends EventListener {

    void handle(EventObject event);

}
