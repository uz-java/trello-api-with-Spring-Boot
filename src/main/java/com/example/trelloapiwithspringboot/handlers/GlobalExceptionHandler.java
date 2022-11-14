package com.example.trelloapiwithspringboot.handlers;

import com.example.trelloapiwithspringboot.exceptions.GenericNotFoundException;
import com.example.trelloapiwithspringboot.exceptions.ValidationException;
import com.example.trelloapiwithspringboot.handlers.errorResponse.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author "Tojaliyev Asliddin"
 * @since 12/11/22 15:23 (Saturday)
 * trello-api-with-Spring-Boot/IntelliJ IDEA
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handle404(GenericNotFoundException e, HttpServletRequest request){
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURI().toString())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiErrorResponse> handle400(ValidationException e,HttpServletRequest request){
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURI().toString())
                .build(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<ApiErrorResponse> handle403(IllegalAccessException e,HttpServletRequest request){
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiErrorResponse> handle500(NullPointerException e,HttpServletRequest request){
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
