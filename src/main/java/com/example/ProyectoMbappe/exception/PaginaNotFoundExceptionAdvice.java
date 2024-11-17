package com.example.ProyectoMbappe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PaginaNotFoundExceptionAdvice {
    @ResponseBody
    @ExceptionHandler({PaginaNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleCarNotFoundException(PaginaNotFoundException ex) {
        return ex.getMessage();
    }
}
