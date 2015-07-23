package com.med.care.dao;


import com.med.care.domain.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReceiverDAO extends JpaRepository<Receiver, String> {

}
