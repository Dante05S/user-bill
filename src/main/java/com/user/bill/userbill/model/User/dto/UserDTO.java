package com.user.bill.userbill.model.User.dto;

import java.io.Serializable;
import java.util.List;

import com.user.bill.userbill.model.Bill.Bill;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class UserDTO implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private List<Bill> bills;
}
