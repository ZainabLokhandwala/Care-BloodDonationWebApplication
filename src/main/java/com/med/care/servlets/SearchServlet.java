package com.med.care.servlets;

import com.med.care.domain.Donor;
import com.med.care.domain.Receiver;
import com.med.care.domain.User;
import com.med.care.service.IDonorService;
import com.med.care.service.IReceiverService;
import com.med.care.service.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends BaseServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String key = req.getParameter("key");
        String criteria = req.getParameter("search_type");
        String criteriaValue = req.getParameter("option_value");

        IReceiverService receiverService =  context.getBean(IReceiverService.class);
        IDonorService donorService = context.getBean(IDonorService.class);
        List<Receiver> receivers =  receiverService.findUser(key, criteria, criteriaValue);
        List<Donor> donors = donorService.findUser(key, criteria, criteriaValue);
        req.setAttribute("donors", donors);
        req.setAttribute("receivers", receivers);

        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
