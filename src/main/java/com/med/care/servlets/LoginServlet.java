package com.med.care.servlets;

import com.med.care.domain.User;
import com.med.care.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet  extends BaseServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IUserService userService = context.getBean(IUserService.class);
        String userName = req.getParameter("user_name");
        String pwd = req.getParameter("pwd");
        try {

            User user = userService.findById(userName);
            if (user.getPassword().equals(doHash(pwd))) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("index");
            } else
                throw new RuntimeException();
        } catch (Exception e) {

            resp.sendRedirect("login");
        }
    }
}
