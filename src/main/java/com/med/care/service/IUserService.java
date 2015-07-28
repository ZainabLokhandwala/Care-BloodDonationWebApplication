package com.med.care.service;

import com.med.care.domain.User;

public interface IUserService extends IService<User> {

    User findOne(String userName);
}
