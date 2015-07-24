package com.med.care.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/donor/signup")
public class DonorSignupServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/donor_signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String userName = req.getParameter("user_name");
        String pwd = req.getParameter("pwd");
        String repwd = req.getParameter("repwd");
        String sex = req.getParameter("sex");
        String bloodType = req.getParameter("blood_type");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        String recentMedications = req.getParameter("recent_medications");
        String allergies = req.getParameter("allergies");
    }
}
