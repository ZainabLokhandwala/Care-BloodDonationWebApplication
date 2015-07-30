package com.med.care.servlets;

import com.med.care.domain.Donor;
import com.med.care.domain.User;
import com.med.care.service.IDonorService;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/donor_edit")
public class DonorEditServlet extends BaseServlet{

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
        String recentMedications = req.getParameter("recent_medications");
        String allergies = req.getParameter("allergies");
        String contactInformation = req.getParameter("contactInformation");
        Part imagePart = req.getPart("image");


        if (!pwd.equals(repwd))
            retry(req, resp);
        else
            try {
                pwd = doHash(ATH, pwd);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        IDonorService donorService = context.getBean(IDonorService.class);
        User user = (User) req.getSession().getAttribute("user");
        Donor donor = donorService.findById(user.getUserName());
        donor.setUserName(userName);
        donor.setPassword(pwd);
        donor.setAge(age);
        donor.setBloodGroup(bloodType);
        donor.setRecentMedications(recentMedications);
        donor.setContactInformation(contactInformation);
        donor.setCountry(country);
        donor.setCity(city);
        donor.setName(name);
        donor.setAllergies(allergies);
        donor.setSex(sex);
        donor.setImage(IOUtils.toByteArray(imagePart.getInputStream()));

        if (donorService.findById(userName) != null) {

            retry(req, resp);
        }

        donorService.save(donor);
        resp.sendRedirect(req.getContextPath() + "/index");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/donor_edit.jsp");
    }

    private void retry(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/donor/signup").forward(req, resp);
    }
}
