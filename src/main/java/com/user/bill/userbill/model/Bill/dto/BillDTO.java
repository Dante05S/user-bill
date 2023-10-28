package com.user.bill.userbill.model.Bill.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class BillDTO implements Serializable {
    private Long id;
    private Double totalAmount;
    private String description;
    private Long idUser;
}
