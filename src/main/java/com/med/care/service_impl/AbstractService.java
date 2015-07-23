package com.med.care.service_impl;


import com.med.care.service.IService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
@Repository
public abstract class AbstractService<E> implements IService<E> {


    public abstract JpaRepository getDAO();


    public List<E> findAll() {

        return getDAO().findAll();
    }
    public abstract E findById(Serializable id);


    public E save(E entity) {
        E foo = (E) getDAO().save(entity);
        return foo;
    }

    public void delete(E entity) {
        getDAO().delete(entity);
    }
}
