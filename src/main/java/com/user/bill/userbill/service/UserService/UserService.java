package com.user.bill.userbill.service.UserService;

import org.springframework.stereotype.Service;

import com.user.bill.userbill.model.User;
import com.user.bill.userbill.repository.UserRepository;
import com.user.bill.userbill.service.BaseService;

@Service
public class UserService extends BaseService<User, Long, UserRepository> implements IUserService {
}
