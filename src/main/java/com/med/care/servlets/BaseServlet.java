package com.med.care.servlets;


import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet{

    protected ApplicationContext context;


    @Override
    public void init() throws ServletException {
        super.init();
        this.context = (ApplicationContext) getServletContext().getAttribute("context");
    }

    @Override
    public void destroy() {
        super.destroy();
        this.context = null;
    }
}
