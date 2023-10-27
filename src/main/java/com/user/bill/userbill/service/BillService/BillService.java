package com.user.bill.userbill.service.BillService;

import org.springframework.stereotype.Service;

import com.user.bill.userbill.model.Bill;
import com.user.bill.userbill.repository.BillRepository;
import com.user.bill.userbill.service.BaseService;

@Service
public class BillService extends BaseService<Bill, Long, BillRepository> implements IBillService {    
}
