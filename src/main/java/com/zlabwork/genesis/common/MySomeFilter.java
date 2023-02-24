package com.zlabwork.genesis.common;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MySomeFilter implements Filter {

    // public void init(FilterConfig config) throws ServletException { }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        System.out.println("MySomeFilter: " + req.getRequestURI());

        // go on
        filterChain.doFilter(request, response);

        // request.getRequestDispatcher("/login").forward(request, response);
    }

    // public void destroy() { }

}
