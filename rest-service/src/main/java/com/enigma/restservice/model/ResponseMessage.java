package com.enigma.restservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ResponseMessage<T> {

    private int code;
    private String messages;
    private T data;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss.SSS")
    private LocalDateTime timeStamp;

    private ResponseMessage(int code, String messages, T data) {
        this.code = code;
        this.messages = messages;
        this.data = data;
        this.timeStamp = LocalDateTime.now();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<>(0, null, data);
    }

    public static ResponseMessage error(int code, String messages) {
        return new ResponseMessage<>(code, messages, null);
    }

    public static <T> ResponseMessage<T> error(int code, String message, T data) {
        return new ResponseMessage<>(code, message, data);
    }

}
