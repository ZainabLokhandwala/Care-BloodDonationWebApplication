package com.med.care.service;


import java.io.Serializable;
import java.util.List;

public interface IService<E> {

    E save(E entity);
    void delete(E entity);
    List<E> findAll();
    E findById(Serializable serializable);
}
