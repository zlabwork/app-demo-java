package com.zlabwork.genesis.config;

import com.zlabwork.genesis.common.MyHttpSessionListener;
import com.zlabwork.genesis.common.MyServletContextListener;
import com.zlabwork.genesis.common.MyServletRequestListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {

    // Register MyHttpSessionListener
    @Bean
    public ServletListenerRegistrationBean<MyHttpSessionListener> sessionListener() {
        ServletListenerRegistrationBean<MyHttpSessionListener> listenerRegBean = new ServletListenerRegistrationBean<>();
        listenerRegBean.setListener(new MyHttpSessionListener());
        return listenerRegBean;
    }

    // Register MyServletContextListener
    @Bean
    public ServletListenerRegistrationBean<MyServletContextListener> contextListener() {
        ServletListenerRegistrationBean<MyServletContextListener> listenerRegBean = new ServletListenerRegistrationBean<>();
        listenerRegBean.setListener(new MyServletContextListener());
        return listenerRegBean;
    }

    // Register MyServletRequestListener
    @Bean
    public ServletListenerRegistrationBean<MyServletRequestListener> requestListener() {
        ServletListenerRegistrationBean<MyServletRequestListener> listenerRegBean = new ServletListenerRegistrationBean<>();
        listenerRegBean.setListener(new MyServletRequestListener());
        return listenerRegBean;
    }

}
