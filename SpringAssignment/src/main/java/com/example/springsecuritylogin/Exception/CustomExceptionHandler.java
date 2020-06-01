package com.example.springsecuritylogin.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UserNotFound.class)
    String handleException(UserNotFound exc, Model model){
        ErrorDetails error = new ErrorDetails();
        model.addAttribute("message",exc.getMessage());
        return "errorHandler";
    }
    @ExceptionHandler(ItemNotFound.class)
    String handleException(ItemNotFound exc, Model model){
        ErrorDetails error = new ErrorDetails();
        model.addAttribute("message",exc.getMessage());
        return "errorHandler";
    }
}
