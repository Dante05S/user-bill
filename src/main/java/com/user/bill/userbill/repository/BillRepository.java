package com.user.bill.userbill.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.bill.userbill.model.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {

}
