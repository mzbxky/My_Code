package com.fc.config;

import com.fc.interceptor.CustomInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 将拦截器注入到容器中
        registry.addInterceptor(new CustomInterceptor())

                .order(-1)
                .addPathPatterns("/**")

                .addPathPatterns("/index.jsp")
                //放行login.jsp
                .excludePathPatterns("/login.jsp")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/**/*.js")
                .excludePathPatterns("/**/*.css")
                .excludePathPatterns("/**/upload/*")
                .excludePathPatterns("/**/statics/**");

    }


}
