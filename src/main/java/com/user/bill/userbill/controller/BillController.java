package com.user.bill.userbill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.bill.userbill.helpers.Http.Http;
import com.user.bill.userbill.model.Bill.Bill;
import com.user.bill.userbill.model.Bill.BillMapper;
import com.user.bill.userbill.model.Bill.dto.BillDTO;
import com.user.bill.userbill.model.Bill.dto.CreateBillDTO;
import com.user.bill.userbill.model.Bill.dto.UpdateBillDTO;
import com.user.bill.userbill.service.BillService.IBillService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {
    @Autowired
    private IBillService service;

    @PostMapping
    public ResponseEntity<?> create (@Valid @RequestBody CreateBillDTO createBill, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Http.getBadRequest(bindingResult.getFieldError().getDefaultMessage());
        }
        Bill bill = BillMapper.createBillToBill(createBill);
        Bill newBill = service.createBill(bill);
        BillDTO newBillDTO = BillMapper.BilltoBillDTO(newBill);
        return Http.getResponseEntity(newBillDTO, HttpStatus.CREATED, "Bill created successfully");
    }

    @PatchMapping("{id}")
    public ResponseEntity<?> update (@Valid @RequestBody UpdateBillDTO updateBillDTO, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Http.getBadRequest(bindingResult.getFieldError().getDefaultMessage());
        }
        
        Bill billUpdate = service.updateBill(id, updateBillDTO);
        BillDTO newBillDTO = BillMapper.BilltoBillDTO(billUpdate);
        String message = String.format("Bill with id (%d) updated successfully", id);
        return Http.getResponseEntity(newBillDTO, HttpStatus.OK, message);
    }

    @DeleteMapping("{id}")
     public ResponseEntity<?> delete (@PathVariable Long id) {
        service.delete(id, "Bill don't exist");
        String message = String.format("Bill %d deleted successfully", id);
        return Http.getResponseEntity(null, HttpStatus.NO_CONTENT, message);
    }
}
