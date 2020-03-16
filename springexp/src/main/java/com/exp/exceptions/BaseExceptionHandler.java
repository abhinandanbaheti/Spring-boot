package com.exp.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = TestException.class)
    public ResponseEntity<Object> exception(final HttpServletRequest request, final HttpServletResponse response, TestException exception) {
        String id  = request.getParameter("id");
        return new ResponseEntity<>("TestObj not found for id "  + id, HttpStatus.NOT_FOUND);
    }
}
