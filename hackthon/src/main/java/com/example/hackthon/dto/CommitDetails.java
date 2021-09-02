package com.example.hackthon.dto;

public class CommitDetails {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommitDetails{" +
            "message='" + message + '\'' +
            '}';
    }
}
