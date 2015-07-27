package com.med.care.servlets;


import com.med.care.domain.Donor;
import com.med.care.domain.Receiver;
import com.med.care.service.IDonorService;
import com.med.care.service.IReceiverService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class HelloWorldServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IDonorService donorService = context.getBean(IDonorService.class);
        IReceiverService receiverService = context.getBean(IReceiverService.class);
        List<Donor> donorList = donorService.findAll();
        List<Receiver> receiverList = receiverService.findAll();

        req.setAttribute("donors", donorList);
        req.setAttribute("receivers", receiverList);

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
