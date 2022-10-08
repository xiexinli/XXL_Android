package com.example.base_library.net_1.exception;

/**
 * 自定义错误信息，统一处理返回处理
 */
public class HttpTimeException extends RuntimeException {

    private String state;
    private String message;
    private String result;

    public HttpTimeException(String state, String detailMessage) {
        super(detailMessage);
        this.state = state;
        this.message = detailMessage;
    }

    public HttpTimeException(String message) {
        this.message = message;
    }

    public HttpTimeException(Throwable e, String state) {
        super(e);
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public HttpTimeException setResult(String result) {
        this.result = result;
        return this;
    }
}

