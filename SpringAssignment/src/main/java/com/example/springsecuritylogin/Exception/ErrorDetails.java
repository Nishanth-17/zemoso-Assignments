package com.example.springsecuritylogin.Exception;
import lombok.Data;
import lombok.NoArgsConstructor;


public @Data @NoArgsConstructor class ErrorDetails {
    private String message;
    private String details;

    public ErrorDetails(String message, String details) {
        super();
        this.message = message;
        this.details = details;
    }
}
