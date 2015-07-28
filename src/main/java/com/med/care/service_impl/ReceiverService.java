package com.med.care.service_impl;

import com.med.care.dao.IReceiverDAO;
import com.med.care.domain.Receiver;
import com.med.care.service.IReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class ReceiverService extends AbstractService<Receiver> implements IReceiverService{

    @Autowired
    private IReceiverDAO receiverDAO;

    @Override
    public JpaRepository getDAO() {
        return receiverDAO;
    }

    @Override
    public Receiver findById(Serializable id) {
        return receiverDAO.findOne((String) id);
    }

    @Override
    public List<Receiver> findUser(String key, String criteria, String criteriaValue) {
        if (criteria == null) {

            return receiverDAO.searchByNameOrUserName(key, key);
        } else if (criteria.equals("city")) {

            return receiverDAO.searchByCityOrNameOrUserName(criteriaValue, key, key);
        } else if (criteria.equals("group")) {

            return receiverDAO.searchByBloodGroupOrNameOrUserName(criteriaValue, key, key);
        } else {

            return receiverDAO.searchByNameOrUserName(key, key);
        }
    }
}
