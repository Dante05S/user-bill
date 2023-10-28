package com.user.bill.userbill.model.User;

import java.util.ArrayList;

import com.user.bill.userbill.model.Bill.Bill;
import com.user.bill.userbill.model.User.dto.CreateUserDTO;
import com.user.bill.userbill.model.User.dto.UserDTO;

public final class UserMapper {
    public static User createUserToUser(CreateUserDTO createUserDTO) {
        return User.builder()
            .name(createUserDTO.getName())
            .age(createUserDTO.getAge())
            .email(createUserDTO.getEmail())
            .bills(new ArrayList<Bill>())
            .build();
    }
    public static UserDTO UsertoUserDTO(User user) {
        return UserDTO.builder()
            .id(user.getId())
            .name(user.getName())
            .age(user.getAge())
            .email(user.getEmail())
            .bills(user.getBills())
            .build();
    }
}
