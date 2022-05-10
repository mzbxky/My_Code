package com.fc.interceptor;

import com.fc.entity.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//自定义拦截器
public class CustomInterceptor implements HandlerInterceptor {
    //控制器执行之前执行此方法，如果是true就放行，否则就被拦下来了
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        TbUser tbUser = (TbUser) session.getAttribute("user");
        try {
            if (tbUser!=null){
                return true;
            }
            response.sendRedirect(request.getContextPath() + "login.jsp");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
