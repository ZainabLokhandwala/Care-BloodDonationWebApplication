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
import java.util.LinkedList;
import java.util.List;

@Service
public class UserService extends AbstractService<User> implements IUserService {

    @Autowired
    private IUserDAO userDao;
    @Autowired
    private IDonorDAO donorDAO;
    @Autowired
    private IReceiverDAO receiverDAO;

    @Override
    public JpaRepository getDAO() {
        return userDao;
    }

    @Override
    public List<User> findInboxedUser(String id) {
        return userDao.findInboxedUser(id);
    }

    @Override
    public User findById(Serializable id) {
        return userDao.findOne((String) id);
    }

    @Override
    public List<User> findUser(String key, String criteria, String criteriaValue) {

        if (criteria == null) {
            List<User> l1 = new LinkedList<User>();
            l1.addAll(receiverDAO.searchByNameOrUserName(key, key));
            l1.addAll(donorDAO.searchByNameOrUserName(key, key));

            return l1;
        } else if (criteria.equals("city")) {

            List<User> l1 = new LinkedList<User>();
            l1.addAll(receiverDAO.searchByCityOrNameOrUserName(criteriaValue, key, key));
            l1.addAll(donorDAO.searchByCityOrNameOrUserName(criteriaValue, key, key));

            return l1;
        } else if (criteria.equals("group")) {

            List<User> l1 = new LinkedList<User>();
            l1.addAll(receiverDAO.searchByBloodGroupOrNameOrUserName(criteriaValue, key, key));
            l1.addAll(donorDAO.searchByBloodGroupOrNameOrUserName(criteriaValue, key, key));

            return l1;
        } else {

            List<User> l1 = new LinkedList<User>();
            l1.addAll(receiverDAO.searchByNameOrUserName(key, key));
            l1.addAll(donorDAO.searchByNameOrUserName(key, key));

            return l1;
        }
    }

    @Override
    public User findOne(String userName) {

        User user = donorDAO.findOne(userName);
        return user != null ? user : receiverDAO.findOne(userName);
    }
}
