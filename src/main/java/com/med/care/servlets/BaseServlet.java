package com.med.care.servlets;


import com.med.care.utils.HashUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.security.NoSuchAlgorithmException;

public class BaseServlet extends HttpServlet{

    protected ApplicationContext context;
    protected static final String ATH = "md5";
    protected Logger logger = Logger.getLogger(BaseServlet.class);

    protected String doHash(String content) throws NoSuchAlgorithmException {

        return doHash(ATH, content);
    }

    protected String doHash(String ath, String content) throws NoSuchAlgorithmException {

        return HashUtil.hash(ath, content);
    }

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
