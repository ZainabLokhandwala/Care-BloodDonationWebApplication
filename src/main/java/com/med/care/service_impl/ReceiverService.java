package com.med.care.service_impl;

import com.med.care.dao.IReceiverDAO;
import com.med.care.domain.Receiver;
import com.med.care.service.IReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

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
}
