package com.med.care.servlets;

import com.med.care.domain.Message;
import com.med.care.domain.User;
import com.med.care.service.IMessageService;
import com.med.care.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/inbox")
public class InboxServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IUserService userService = context.getBean(IUserService.class);
        String receiver = req.getParameter("name");
        req.setAttribute("receiver", receiver);
        User user = (User) req.getSession().getAttribute("user");
        User otherUser = userService.findOne(receiver);

        List<Message> result = new ArrayList<Message>();
        List<Message> messages = user.getReceivedMessages();
        List<Message> sentMessages = user.getSentMessages();

        messages.addAll(sentMessages);

        for (Message m: messages) {

            if (m.getSender().getUserName().equals(user.getUserName()) &&
                    m.getReceiver().getUserName().equals(otherUser.getUserName())) {
                result.add(m);
            }
            if (m.getReceiver().getUserName().equals(user.getUserName()) &&
                    m.getSender().getUserName().equals(otherUser.getUserName())) {

                result.add(m);
            }
        }

        Collections.sort(result);
        req.setAttribute("m", result);

        IMessageService messageService = context.getBean(IMessageService.class);
//        req.setAttribute("messages", messageService.findBySenderAndReceiver(user.getUserName(), receiver));

        req.getRequestDispatcher("/WEB-INF/inbox.jsp").forward(req, resp);
    }
}
