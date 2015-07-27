package com.med.care.servlets;

import com.med.care.domain.User;
import com.med.care.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@WebServlet("/user/image")
public class UserPhotoServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("image/jpeg");
        String name = req.getParameter("name");
        IUserService userService = context.getBean(IUserService.class);
        User user = userService.findById(name);
        if (user != null) {

            resp.getOutputStream().write(user.getImage());
            resp.getOutputStream().flush();
            resp.setStatus(200);
        }
    }
}
