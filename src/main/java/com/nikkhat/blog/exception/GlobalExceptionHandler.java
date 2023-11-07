package com.nikkhat.blog.exception;

import com.nikkhat.blog.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exception){

        String msg = exception.getMessage();

        ApiResponse apiResponse = ApiResponse.builder().message(msg).success(true).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);

    }
}
