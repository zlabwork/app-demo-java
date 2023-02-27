package com.zlabwork.genesis.event;

import java.util.EventObject;

public class MySomeEvent extends EventObject {

    private String message;

    public MySomeEvent(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
