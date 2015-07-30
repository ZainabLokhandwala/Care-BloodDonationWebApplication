package com.med.care.service_impl;

import com.med.care.dao.IMessageDAO;
import com.med.care.domain.Message;
import com.med.care.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class MessageService extends AbstractService<Message> implements IMessageService {

    @Autowired
    private IMessageDAO messageDAO;

    @Override
    public JpaRepository getDAO() {
        return messageDAO;
    }

    @Override
    public Message findById(Serializable id) {
        return messageDAO.findOne((Integer) id);
    }

    @Override
    public List<Message> findBySenderAndReceiver(String sender, String receiver) {
        List<Message> sendMessages = messageDAO.findBySenderUserNameAndReceiverUserName(sender, receiver);
        List<Message> receivedMessages = messageDAO.findBySenderUserNameAndReceiverUserName(receiver, sender);
        sendMessages.addAll(receivedMessages);
        return sendMessages;
    }
}
