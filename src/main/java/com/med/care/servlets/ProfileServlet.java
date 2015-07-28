package com.med.care.servlets;


import com.med.care.domain.Donor;
import com.med.care.domain.Receiver;
import com.med.care.domain.User;
import com.med.care.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/profile")
public class ProfileServlet extends BaseServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("name");
        IUserService userService = context.getBean(IUserService.class);
        User user = userService.findOne(userName);
        if (user instanceof Donor) {

            Donor donor = (Donor) user;
            req.setAttribute("profile", donor);
            logger.info("recent medications: " + donor.getRecentMedications());
            req.setAttribute("type", 0);
        } else if (user instanceof Receiver) {

            Receiver receiver = (Receiver) user;
            req.setAttribute("profile", receiver);
            req.setAttribute("type", 1);
        }

        if (user != null)
            req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
        else
            resp.sendRedirect(req.getContextPath() + "/index");
    }
}
