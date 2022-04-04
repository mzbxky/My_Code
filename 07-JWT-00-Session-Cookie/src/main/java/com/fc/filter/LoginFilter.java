package com.fc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

//        // 获取请求URL中的路径部分
//        String uri = httpServletRequest.getRequestURI();
//
//        HttpSession session = httpServletRequest.getSession(false);
//
//        // 如果要登录
//        if (uri.endsWith("login") || uri.endsWith("index.jsp")) {
//            chain.doFilter(httpServletRequest, httpServletResponse);
//        } else if (session == null) {
//            httpServletResponse.sendRedirect("/index.jsp");
//        } else if (session.getAttribute("username") != null) {
//            chain.doFilter(httpServletRequest, httpServletResponse);
//        } else {
//            httpServletResponse.sendRedirect("/index.jsp");
//        }
        //获取url的路径部分
        String uri = httpServletRequest.getRequestURI();
        HttpSession session = httpServletRequest.getSession(false);
        //如果要登录
        if(uri.endsWith("login")||uri.endsWith("index.jsp")){
            //如果请求的是登录页,放行
            chain.doFilter(httpServletRequest,httpServletResponse);

        }else if(session == null){
            httpServletResponse.sendRedirect("/index.jsp");
        }else if(session != null){
            chain.doFilter(httpServletRequest,httpServletResponse);
        }else {
            httpServletResponse.sendRedirect("/index.jsp");
        }
    }

    @Override
    public void destroy() {
    }
}