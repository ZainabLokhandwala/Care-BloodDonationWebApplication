package com.med.care.service;

import com.med.care.domain.Message;

import java.io.Serializable;
import java.util.List;


public interface IMessageService extends IService<Message> {

    List<Message> findBySenderAndReceiver(String sender, String receiver);
}
