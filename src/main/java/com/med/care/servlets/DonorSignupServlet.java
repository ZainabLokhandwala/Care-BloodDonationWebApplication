package com.med.care.servlets;

import com.med.care.domain.Donor;
import com.med.care.service.IDonorService;
import com.med.care.service_impl.DonorService;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/donor/signup")
@MultipartConfig
public class DonorSignupServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/donor_signup.jsp").forward(req, resp);
    }

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

        Donor donor = new Donor(name, userName, pwd, age, sex, bloodType, allergies, city, country, contactInformation, recentMedications);
        donor.setImage(IOUtils.toByteArray(imagePart.getInputStream()));

        // get service bean from spring application context
        IDonorService donorService = context.getBean(IDonorService.class);

        if (donorService.findById(userName) != null) {

            retry(req, resp);
        }

        donorService.save(donor);
        resp.sendRedirect(req.getContextPath() + "/index");
    }

    private void retry(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/donor/signup").forward(req, resp);
    }
}
