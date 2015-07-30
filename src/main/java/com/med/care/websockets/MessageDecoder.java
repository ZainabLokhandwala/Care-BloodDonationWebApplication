package com.med.care.websockets;


import com.med.care.dao.IMessageDAO;
import com.med.care.domain.Message;
import com.med.care.filters.LoginFilter;
import com.med.care.service.IUserService;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class MessageDecoder implements Decoder.Text<Message> {

    private ApplicationContext context = LoginFilter.context;

    @Override
    public Message decode(String s) throws DecodeException {

        Message message = new Message();
        JSONObject jsonObject = new JSONObject(s);

        message.setContent(jsonObject.get("content").toString());
        message.setDateTime(jsonObject.getLong("dateTime"));

        String senderId = jsonObject.get("sender").toString();
        String receiverId = jsonObject.get("receiver").toString();

        // get service beans
        IMessageDAO messageService = context.getBean(IMessageDAO.class);
        IUserService userService = context.getBean(IUserService.class);

        // retrieve sender and receiver information
        message.setSender(userService.findOne(senderId));
        message.setReceiver(userService.findOne(receiverId));
        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return s != null;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
