package com.user.bill.userbill.model.Bill;

import com.user.bill.userbill.model.Bill.dto.BillDTO;
import com.user.bill.userbill.model.Bill.dto.CreateBillDTO;
import com.user.bill.userbill.model.Bill.dto.UpdateBillDTO;
import com.user.bill.userbill.model.User.User;

public final class BillMapper {
     public static Bill createBillToBill(CreateBillDTO createBillDTO) {
        return Bill.builder()
            .totalAmount(createBillDTO.getTotalAmount())
            .description(createBillDTO.getDescription())
            .user(User.builder().id(createBillDTO.getUserId()).build())
            .build();
    }
    public static Bill updateBillToBill(UpdateBillDTO updateBillDTO) {
        return Bill.builder()
            .totalAmount(updateBillDTO.getTotalAmount())
            .description(updateBillDTO.getDescription())
            .build();
    }
    public static BillDTO BilltoBillDTO(Bill bill) {
        return BillDTO.builder()
            .id(bill.getId())
            .totalAmount(bill.getTotalAmount())
            .description(bill.getDescription())
            .idUser(bill.getUser().getId())
            .build();
    }
}
