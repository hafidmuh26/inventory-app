package com.enigma.restservice.exception;

public class ApplicationException extends RuntimeException {

    private Integer code;

    public ApplicationException(Integer code) {
        this.code = code;
    }

    public ApplicationException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ApplicationException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public ApplicationException(Throwable cause, Integer code) {
        super(cause);
        this.code = code;
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
