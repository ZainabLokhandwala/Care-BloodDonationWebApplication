package com.med.care.servlets;

import com.med.care.domain.Receiver;
import com.med.care.domain.User;
import com.med.care.service.IReceiverService;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

@WebServlet("/receiver_edit")
public class ReceiverEditServlet extends BaseServlet{

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

        // get service bean from spring application context
        IReceiverService receiverService = context.getBean(IReceiverService.class);
        User user = (User) req.getSession().getAttribute("user");

        Receiver receiver = receiverService.findById(user.getUserName());
        receiver.setUserName(userName);
        receiver.setName(name);
        receiver.setAllergies(allergies);
        receiver.setContactInformation(contactInformation);
        receiver.setSex(sex);
        receiver.setCity(city);
        receiver.setCountry(country);
        receiver.setPassword(pwd);
        receiver.setBloodGroup(bloodType);
        receiver.setDateNeeded(dateNeeded);
        receiver.setQuantityNeeded(quantity_needed);
        receiver.setImage(IOUtils.toByteArray(imagePart.getInputStream()));

        if (receiverService.findById(userName) != null) {

            retry(req, resp);
        }

        receiverService.save(receiver);
        resp.sendRedirect(req.getContextPath() + "/index");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/receiver_edit.jsp");
    }

    private void retry(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/donor/signup").forward(req, resp);
    }
}
