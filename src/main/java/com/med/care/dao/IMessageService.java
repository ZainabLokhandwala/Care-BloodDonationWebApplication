package com.med.care.dao;


import com.med.care.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMessageService extends JpaRepository<Message, Integer> {
}
