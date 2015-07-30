package com.med.care.websockets;

import com.med.care.domain.Message;
import com.med.care.domain.User;
import com.med.care.service.IMessageService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Chat server endpoint
 */
@ServerEndpoint(value = "/chat",
        configurator = ChatServer.class,
        encoders = MessageEncoder.class,
        decoders = MessageDecoder.class)
public class ChatServer extends ServerEndpointConfig.Configurator {

    /**
     * We manage chat between user via a Set of user chat session.
     * The Set must be synchronized
     */
    private static Set<Session> userSessions = Collections.synchronizedSet(new HashSet<Session>());
    private Logger logger = Logger.getLogger(ChatServer.class);
    /**
     * Spring application context
     */
    private ApplicationContext context;

    @OnMessage
    public void onMessage(Message message, Session session) throws IOException, EncodeException {

        IMessageService messageService = context.getBean(IMessageService.class);
        messageService.save(message);

        Map<String, Object> properties = session.getUserProperties();
        String userName = (String) properties.get("userName");

        if (userName == null) {

            properties.put("userName", message.getSender().getUserName());
        } else {

            for (Session s : userSessions) {

                try {
                    if (s.isOpen() && (s.getUserProperties().get("userName").
                            equals(message.getReceiver().getUserName()))
                            || s.getUserProperties().get("userName").
                            equals(message.getSender().getUserName())) {

                        s.getBasicRemote().sendObject(message);
                    }
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        }
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        logger.info(session.getId() + " has opened a connection");
        userSessions.add(session);
        HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
        ServletContext servletContext = httpSession.getServletContext();
        this.context = (ApplicationContext) servletContext.getAttribute("context");
        User user = (User) httpSession.getAttribute("user");
        session.getUserProperties().put("userName", user.getUserName());
    }

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {

        HttpSession httpSession = (HttpSession) request.getHttpSession();
        sec.getUserProperties().put("httpSession", httpSession);
    }
}
