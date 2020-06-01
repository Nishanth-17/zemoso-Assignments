package com.example.springsecuritylogin.Exception;

public class ItemNotFound extends RuntimeException{
    public ItemNotFound(int id){
        super((String.valueOf(id)));
    }
}
