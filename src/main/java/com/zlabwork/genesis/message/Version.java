package com.zlabwork.genesis.message;

public class Version {

    private long code = 0;

    private String message = "";

    private String data = "";

    public Version(long code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }

}
