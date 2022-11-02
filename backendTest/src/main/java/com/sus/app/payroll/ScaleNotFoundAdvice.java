package com.sus.app.payroll;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ScaleNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ScaleNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ScaleNotFoundHandler(ScaleNotFoundException ex) {
        return ex.getMessage();
    }
}
