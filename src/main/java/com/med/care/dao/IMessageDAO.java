package com.med.care.dao;


import com.med.care.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMessageDAO extends JpaRepository<Message, Integer> {

    @Query("from Message m where m.sender.userName=:sender and m.receiver.userName=:receiver")
    List<Message> findBySenderUserNameAndReceiverUserName(@Param("sender")String senderUserName,
                                                         @Param("receiver") String receiverUserName);
}
