package com.fc.filter;

import javax.servlet.*;
import java.io.IOException;
//@WebFilter("/*")
//@Component
//@Order(-21)
public class SexFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤前：好看的有钱的");
        chain.doFilter(req,resp);
        System.out.println("过滤后：有钱的");
    }
}
