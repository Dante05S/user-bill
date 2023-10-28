package com.user.bill.userbill.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.bill.userbill.model.User.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}