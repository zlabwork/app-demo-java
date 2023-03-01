package com.zlabwork.genesis.message;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultFormat<T> {

    private long code;

    private String message;

    private T data;

    private String reference;

    protected ResultFormat() {
    }

    protected ResultFormat(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    protected ResultFormat(long code, String message, T data, String reference) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
        this.setReference(reference);
    }

    /**
     * 成功返回结果
     */
    public static <T> ResultFormat<T> success() {
        return new ResultFormat<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResultFormat<T> success(T data) {
        return new ResultFormat<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> ResultFormat<T> success(T data, String message) {
        return new ResultFormat<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResultFormat<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> ResultFormat<T> failed(IErrorCode errorCode) {
        return new ResultFormat<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResultFormat<T> failed(String message) {
        return new ResultFormat<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     *
     * @param err
     * @param reference
     */
    public static <T> ResultFormat<T> failed(IErrorCode err, String reference) {
        return new ResultFormat<T>(err.getCode(), err.getMessage(), null, reference);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResultFormat<T> validateFailed() {
        return failed(ResultCode.INVALIDATE);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> ResultFormat<T> validateFailed(String message) {
        return new ResultFormat<T>(ResultCode.INVALIDATE.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResultFormat<T> unauthorized(T data) {
        return new ResultFormat<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResultFormat<T> forbidden(T data) {
        return new ResultFormat<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
