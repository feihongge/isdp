package edu.scau.mis.common.web.exception;

import edu.scau.mis.common.web.domain.HttpCode;

public class ServiceException extends RuntimeException{
    private int code;
    private String message;
    public ServiceException(String message) {
        this.message = message;
    }
    public ServiceException(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public ServiceException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public ServiceException(HttpCode httpCode) {
        this.code = httpCode.getCode();
        this.message = httpCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
