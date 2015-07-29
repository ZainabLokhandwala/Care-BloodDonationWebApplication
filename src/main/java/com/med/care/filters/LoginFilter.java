package com.med.care.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class LoginFilter implements Filter {

    private Logger logger = Logger.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        logger.info("Login Servlet started");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        logger.info(httpServletRequest.getRequestURI());
        if (httpServletRequest.getRequestURI().contains("welcome")
                || httpServletRequest.getRequestURI().contains("login")
                || httpServletRequest.getRequestURI().contains("resources")
                || httpServletRequest.getRequestURI().contains("signup")
                || (httpServletRequest.getRequestURI()).equals(httpServletRequest.getContextPath() + "/")) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            logger.info("not authorized");
            logger.info(session.getAttribute("user"));
            ((HttpServletResponse) response).sendRedirect(httpServletRequest.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {

    }
}
