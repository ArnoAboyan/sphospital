package com.hospital.sphospital.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController{

//    @ExceptionHandler(Throwable.class)
//    public String handleException(Throwable ex, Model model) {
//        model.addAttribute("errorMessage", ex.getMessage());
//        return "error";
//    }
}