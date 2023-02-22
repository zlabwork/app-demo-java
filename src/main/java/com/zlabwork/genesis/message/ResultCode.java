package com.zlabwork.genesis.message;

public enum ResultCode implements IErrorCode {

    SUCCESS(200, "success"),
    FAILED(500, "failed"),
    NOT_FOUND(404, "not found"),
    INVALIDATE(402, "invalid"),
    UNAUTHORIZED(401, "unauthorized"),
    FORBIDDEN(403, "forbidden");

    private long code;

    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
