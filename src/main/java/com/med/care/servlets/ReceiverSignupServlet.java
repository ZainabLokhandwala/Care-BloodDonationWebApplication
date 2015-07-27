package com.med.care.servlets;

import com.med.care.domain.Receiver;
import com.med.care.service_impl.ReceiverService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/receiver/signup")
public class ReceiverSignupServlet extends BaseServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String userName = req.getParameter("user_name");
        String pwd = req.getParameter("pwd");
        String repwd = req.getParameter("repwd");
        boolean sex = Boolean.valueOf(req.getParameter("sex"));
        String bloodType = req.getParameter("blood_type");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        String quantityNeeded = req.getParameter("quantity_needed");
        String allergies = req.getParameter("allergies");
        String contactInformation = req.getParameter("contactInformation");
        Date dateNeeded = Date.valueOf(req.getParameter("date_needed"));
        int quantity_needed = Integer.parseInt("quantity_needed");

        if (!pwd.equals(repwd))
            req.getRequestDispatcher("/donor/signup").forward(req, resp);

        Receiver receiver = new Receiver(name, userName, pwd, age, sex, bloodType, allergies, city, country, contactInformation, dateNeeded, quantity_needed);
        // get service bean from spring application context
        ReceiverService receiverService = context.getBean(ReceiverService.class);
        receiverService.save(receiver);
        resp.sendRedirect("/index");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/receiver_signup.jsp").forward(req, resp);
    }
}
