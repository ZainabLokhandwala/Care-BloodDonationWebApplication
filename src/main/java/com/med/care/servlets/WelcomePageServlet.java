package com.med.care.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/welcome")
public class WelcomePageServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null)
            req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(req, resp);
    }
}
