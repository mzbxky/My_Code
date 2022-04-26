package com.fc.filter;


import javax.servlet.*;
import java.io.IOException;
//@WebFilter("/*")
//@Component
//@Order(-1)
public class RichFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("女的");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("徐凯玥");
    }
}
