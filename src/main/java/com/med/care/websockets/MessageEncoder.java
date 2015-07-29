package com.med.care.websockets;

import com.med.care.domain.Message;
import org.json.JSONObject;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Message> {

    @Override
    public String encode(Message object) throws EncodeException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dateTime", object.getDateTime());
        jsonObject.put("content", object.getContent());
        jsonObject.put("sender", object.getSender() == null ? null : object.getSender().getUserName());
        jsonObject.put("receiver", object.getReceiver() == null ? null : object.getReceiver().getUserName());
        return jsonObject.toString();
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
