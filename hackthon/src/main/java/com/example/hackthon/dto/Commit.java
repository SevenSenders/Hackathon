package com.example.hackthon.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class Commit {

    private String sha;
    private String message;

    @JsonProperty("commit")
    private CommitDetails details;

    public CommitDetails getDetails() {
        return details;
    }

    public void setDetails(CommitDetails details) {
        this.details = details;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Commit{" +
            "sha='" + sha + '\'' +
            ", message='" + message + '\'' +
            ", details=" + details +
            '}';
    }
}
