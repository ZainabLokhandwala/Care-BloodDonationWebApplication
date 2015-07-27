package com.med.care.service_impl;


import com.med.care.dao.IUserDAO;
import com.med.care.domain.User;
import com.med.care.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserService extends AbstractService<User> implements IUserService{

    @Autowired
    private IUserDAO userDao;

    @Override
    public JpaRepository getDAO() {
        return userDao;
    }

    @Override
    public User findById(Serializable id) {
        return userDao.findOne((String) id);
    }
}
