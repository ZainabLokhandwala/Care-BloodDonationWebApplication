package com.med.care.listener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Logger logger = Logger.getLogger(ContextListener.class);
        ApplicationContext context = new AnnotationConfigApplicationContext(com.med.care.config.ApplicationContext.class);
        sce.getServletContext().setAttribute("context", context);
        logger.info("created spring application context and load it to servlet context!!!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
