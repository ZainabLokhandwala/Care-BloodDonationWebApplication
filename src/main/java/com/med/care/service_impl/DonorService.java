package com.med.care.service_impl;

import com.med.care.dao.IDonorDAO;
import com.med.care.domain.Donor;
import com.med.care.service.IDonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Qualifier("donorService")
public class DonorService  extends AbstractService<Donor> implements IDonorService{

    @Autowired
    private IDonorDAO donorDAO;

    @Override
    public JpaRepository getDAO() {
        return donorDAO;
    }

    @Override
    public Donor findById(Serializable id) {
        return donorDAO.findOne((String) id);
    }
}
