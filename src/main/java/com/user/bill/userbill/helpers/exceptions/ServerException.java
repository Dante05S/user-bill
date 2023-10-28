package com.user.bill.userbill.helpers.exceptions;

import org.springframework.http.HttpStatus;

public class ServerException extends CustomException {
    public ServerException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
