package com.user.bill.userbill.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.bill.userbill.helpers.Http.Http;
import com.user.bill.userbill.helpers.Http.dto.ResponseDTO;
import com.user.bill.userbill.helpers.exceptions.CustomException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ResponseDTO<Object>> customExceptionHandler(CustomException ex) {
        ArrayList<String> errors = new ArrayList<String>();
        errors.add(ex.getMessage());
        return new ResponseEntity<ResponseDTO<Object>>(
            Http.getError(ex.getCode(), errors),
            ex.getCode()
        );
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ResponseDTO<Object>> handleMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
        ArrayList<String> errors = new ArrayList<String>();
        errors.add("Content-Type is invalid");
        return new ResponseEntity<ResponseDTO<Object>>(
            Http.getError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, errors),
            HttpStatus.UNSUPPORTED_MEDIA_TYPE
        );
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseDTO<Object>> runtimeExceptionHandler(Exception ex) {
        ArrayList<String> errors = new ArrayList<String>();
        errors.add(ex.getMessage());
        return new ResponseEntity<ResponseDTO<Object>>(
            Http.getError(HttpStatus.INTERNAL_SERVER_ERROR, errors),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
