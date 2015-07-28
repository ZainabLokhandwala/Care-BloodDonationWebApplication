package com.med.care.service_impl;


import com.med.care.dao.IDonorDAO;
import com.med.care.dao.IReceiverDAO;
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
    @Autowired private IDonorDAO donorDAO;
    @Autowired private IReceiverDAO receiverDAO;

    @Override
    public JpaRepository getDAO() {
        return userDao;
    }

    @Override
    public User findById(Serializable id) {
        return userDao.findOne((String) id);
    }

    @Override
    public User findOne(String userName) {

        User user = donorDAO.findOne(userName);
        return user!= null? user: receiverDAO.findOne(userName);
    }
}
