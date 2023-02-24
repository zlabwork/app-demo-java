package com.zlabwork.genesis.common;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

public class MyHttpSessionListener implements HttpSessionListener {

    private final AtomicInteger sessionCount = new AtomicInteger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionCount.incrementAndGet();
        setActiveSessionCount(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionCount.decrementAndGet();
        setActiveSessionCount(se);
    }

    private void setActiveSessionCount(HttpSessionEvent se) {
        se.getSession().getServletContext().setAttribute("activeSessions", sessionCount.get());
        System.out.println("Total Active Session: " + sessionCount.get());
    }

}
