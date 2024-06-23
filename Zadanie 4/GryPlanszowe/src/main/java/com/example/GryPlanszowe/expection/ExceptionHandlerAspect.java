package com.example.GryPlanszowe.expection;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Aspect
@ControllerAdvice
public class ExceptionHandlerAspect {

    @AfterThrowing(pointcut = "execution(* com.example.GryPlanszowe.service.*.*(..))", throwing = "ex")
    public void loginException (Exception ex) {
        System.err.println("aa" + ex.getMessage());
    }


@ExceptionHandler(Exception.class)
public ResponseEntity<Map<String, String>> handleException(Exception ex){
    Map<String, String> errorResponse = new HashMap<>();
    errorResponse.put("Error", ex.getMessage());

    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
}
}