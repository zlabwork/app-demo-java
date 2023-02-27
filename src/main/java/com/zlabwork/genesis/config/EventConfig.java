package com.zlabwork.genesis.config;


import com.zlabwork.genesis.common.EventSource;
import com.zlabwork.genesis.event.MySomeEvent;
import com.zlabwork.genesis.listener.MyEventListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;

@Configuration
public class EventConfig {

    @Bean
    public EventSource eventSource() {
        EventSource src = new EventSource();
        src.setEventMaps(new HashMap<>() {{

            // TODO:: events and listeners map
            put((new MySomeEvent("TestEvent")).toString(), new ArrayList<>() {{
                add(new MyEventListener("ListenerA"));
                add(new MyEventListener("ListenerB"));
            }});

        }});

        return src;
    }

}
