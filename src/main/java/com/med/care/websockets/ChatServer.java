package com.med.care.websockets;

import com.med.care.dao.IMessageService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.ServerEndpointConfig;
import java.io.IOException;

@ServerEndpoint(value = "/chat", configurator = ChatServer.class)
public class ChatServer extends ServerEndpointConfig.Configurator {

    private Logger logger = Logger.getLogger(ChatServer.class);
    private EndpointConfig config;
    private ApplicationContext context;

    @OnMessage
    public void onMessage(String message, Session session) {

        IMessageService messageService = context.getBean(IMessageService.class);
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        logger.info(session.getId() + " has opened a connection");
        HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
        ServletContext servletContext = httpSession.getServletContext();
        this.context = (ApplicationContext) servletContext.getAttribute("context");
        this.config = config;
    }

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {

        HttpSession httpSession = (HttpSession) request.getHttpSession();
        sec.getUserProperties().put("httpSession", httpSession);
    }
}
