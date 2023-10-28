package com.user.bill.userbill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.bill.userbill.helpers.Http.Http;
import com.user.bill.userbill.model.User.User;
import com.user.bill.userbill.model.User.UserMapper;
import com.user.bill.userbill.model.User.dto.CreateUserDTO;
import com.user.bill.userbill.model.User.dto.UserDTO;
import com.user.bill.userbill.service.UserService.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private IUserService service;

    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody CreateUserDTO createUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Http.getBadRequest(bindingResult.getFieldError().getDefaultMessage());
        }
        User user = UserMapper.createUserToUser(createUser);
        User newUser = service.create(user);
        UserDTO newUserDTO = UserMapper.UsertoUserDTO(newUser);
        return Http.getResponseEntity(newUserDTO, HttpStatus.CREATED, "User created successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById (@PathVariable Long id) {
        User user = service.get(id, "User don't exist");
        UserDTO userDTO = UserMapper.UsertoUserDTO(user);
        String message = String.format("Get user with id (%d) successfully", id);
        return Http.getResponseEntity(userDTO, HttpStatus.OK, message);
    }
}
