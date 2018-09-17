package com.ttylink.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AppMessage {
    private String id;

    private String message;
    @DateTimeFormat(pattern="yyyy-DD-dd")
    private Date senddate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }
}