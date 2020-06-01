package com.example.springsecuritylogin.Exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound(int s) {
        super(String.valueOf(s));
    }
}
