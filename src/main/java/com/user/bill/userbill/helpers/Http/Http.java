package com.user.bill.userbill.helpers.Http;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.user.bill.userbill.helpers.Http.dto.ResponseDTO;

public final class Http {
    public static <T> ResponseDTO<T> getResponse(T data, HttpStatus code, String message) {
        return ResponseDTO.<T>builder()
            .data(data)
            .code(code.value())
            .success(true)
            .message(message)
            .errors(new ArrayList<>())
            .build();
    } 
    public static <T> ResponseDTO<T> getResponse(T data, HttpStatus code, String message, boolean success) {
        return ResponseDTO.<T>builder()
            .data(data)
            .code(code.value())
            .success(success)
            .message(message)
            .errors(new ArrayList<>())
            .build();
    }
    public static <T> ResponseEntity<ResponseDTO<T>> getResponseEntity(T data, HttpStatus code, String message) {
        return new ResponseEntity<ResponseDTO<T>>(
            getResponse(data, code, message),
            code
        );
    }

    public static ResponseDTO<Object> getError (HttpStatus code, List<String> errors) {
        return ResponseDTO.<Object>builder()
            .data(null)
            .code(code.value())
            .success(false)
            .message(errors.get(0))
            .errors(errors)
            .build();
    }

    public static ResponseEntity<ResponseDTO<Object>> getBadRequest (String message) {
        final String error = message;
        final ArrayList<String> errors = new ArrayList<String>();
        errors.add(error);
        return new ResponseEntity<ResponseDTO<Object>>(
            getError(HttpStatus.BAD_REQUEST, errors),
            HttpStatus.BAD_REQUEST
        );
    }
}
