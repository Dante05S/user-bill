package com.user.bill.userbill.helpers.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class CustomException extends RuntimeException {
    private HttpStatus code;
    public CustomException(String message, HttpStatus code) {
        super(message);
        this.code = code;
    }
}
