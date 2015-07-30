package com.med.care.servlets;

import com.med.care.domain.User;
import com.med.care.service.IMessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/inbox")
public class InboxServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String receiver = req.getParameter("name");
        req.setAttribute("receiver", receiver);
        User user = (User) req.getSession().getAttribute("user");

        IMessageService messageService = context.getBean(IMessageService.class);
        req.setAttribute("messages", messageService.findBySenderAndReceiver(user.getUserName(), receiver));

        req.getRequestDispatcher("/WEB-INF/inbox.jsp").forward(req, resp);
    }
}
