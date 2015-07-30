package com.med.care.servlets;

import com.med.care.domain.User;
import com.med.care.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteUserServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IUserService userService  = context.getBean(IUserService.class);
        User user = (User) req.getSession().getAttribute("user");
        req.getSession().invalidate();
        userService.delete(user);
        resp.sendRedirect(req.getContextPath() + "/welcome");
    }
}
