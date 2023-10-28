package com.user.bill.userbill.service.BillService;

import com.user.bill.userbill.model.Bill.Bill;
import com.user.bill.userbill.model.Bill.dto.UpdateBillDTO;
import com.user.bill.userbill.service.IBaseService;

public interface IBillService extends IBaseService<Bill, Long> {
    Bill createBill (Bill bill);
    Bill updateBill (Long id, UpdateBillDTO bill);
}
