package com.med.care.servlets;

import com.med.care.domain.Receiver;
import com.med.care.service.IReceiverService;
import com.med.care.service_impl.ReceiverService;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

@WebServlet("/receiver/signup")
@MultipartConfig
public class ReceiverSignupServlet extends BaseServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String userName = req.getParameter("user_name");
        userName.replaceAll("\\s+", "");
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
        int quantity_needed = Integer.parseInt(req.getParameter("quantity_needed"));
        Part imagePart = req.getPart("image");

        if (!pwd.equals(repwd))
            retry(req, resp);
        else
            try {
                pwd = doHash(ATH, pwd);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        Receiver receiver = new Receiver(name, userName, pwd, age, sex, bloodType, allergies, city, country, contactInformation, dateNeeded, quantity_needed);
        receiver.setImage(IOUtils.toByteArray(imagePart.getInputStream()));
        // get service bean from spring application context
        IReceiverService receiverService = context.getBean(IReceiverService.class);

        if (receiverService.findById(userName) != null) {

            retry(req, resp);
        }

        receiverService.save(receiver);
        resp.sendRedirect("/index");
    }

    private void retry(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/donor/signup").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/receiver_signup.jsp").forward(req, resp);
    }
}
