package com.user.bill.userbill.helpers.exceptions;

import org.springframework.http.HttpStatus;

public class NotAuthorizedException extends CustomException {
    public NotAuthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
    
}
