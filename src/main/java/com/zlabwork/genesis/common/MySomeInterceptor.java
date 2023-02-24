package com.zlabwork.genesis.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MySomeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("---- Interceptor: It Works ----");

        String token = request.getHeader("Authorization");
        System.out.println("Authorization: " + token);
        try {
            if (token.length() > 0) {
                return true;
            }
        } catch (Exception e) {
        }
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println("{\"message\":\"Error Authorization\"}");
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}