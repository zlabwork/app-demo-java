package com.zlabwork.genesis.common;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextEvent initialized.");
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("admin", "Joe");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.removeAttribute("admin");
        System.out.println("ServletContextEvent destroyed.");
    }

}
