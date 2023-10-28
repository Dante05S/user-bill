package com.user.bill.userbill.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.bill.userbill.helpers.Http.Http;

@RestController
@RequestMapping
public class IndexController {
    @GetMapping
    public ResponseEntity<?> index () {
        return Http.getResponseEntity(null, HttpStatus.OK, "Welcome to User Bill microservice!");
    }

    @GetMapping("api/v1")
    public ResponseEntity<?> indexApi () {
        return Http.getResponseEntity(null, HttpStatus.OK, "Welcome to User Bill microservice!");
    }
}
