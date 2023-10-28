package com.user.bill.userbill.service.BillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.user.bill.userbill.model.Bill.Bill;
import com.user.bill.userbill.model.Bill.dto.UpdateBillDTO;
import com.user.bill.userbill.repository.BillRepository;
import com.user.bill.userbill.service.BaseService;
import com.user.bill.userbill.service.UserService.IUserService;

@Service
public class BillService extends BaseService<Bill, Long, BillRepository> implements IBillService {
    @Autowired
    IUserService userService;

    @Autowired
    public BillService(@Qualifier("billRepository") BillRepository billRepository) {
        super(billRepository);
    }

    @Override
    public Bill createBill(Bill bill) {
        final Long userId = bill.getUser().getId();
        String messageError = String.format("The user by id (%d) don't exist", userId);
        userService.get(userId, messageError);
        return this.create(bill);
    } 
    
    @Override
    public Bill updateBill(Long id, UpdateBillDTO newBill) {
        final Bill updateBill = this.get(id, "Bill don't exist");
        Bill bill = Bill.builder()
            .id(id)
            .totalAmount(newBill.getTotalAmount())
            .description(newBill.getDescription())
            .user(updateBill.getUser())
            .build();
        return this.update(id, bill, "Bill don't exist");
    }
}
