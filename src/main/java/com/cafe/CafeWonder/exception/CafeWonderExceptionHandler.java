package com.cafe.CafeWonder.exception;

import com.cafe.CafeWonder.exception.customexception.InvalidUserException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CafeWonderExceptionHandler {

    @ExceptionHandler(value = {InvalidUserException.class,Exception.class})
    public String handleException(Exception ex, Model model)
    {
        model.addAttribute("exceptionName",ex.getClass());
        model.addAttribute("errorMessage",ex.getMessage());
        return "error.html";
    }
}
