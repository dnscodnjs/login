package com.codingrecipe.member;

import com.codingrecipe.member.intercepter.LogIntercepter;
import com.codingrecipe.member.intercepter.LoginCheckInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LogIntercepter())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error"); // 모든걸 허용하지만 얘네는 뺄거야!!

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/members/login","/member/save","/member/logout", "/css/**", "/*.ico", "/error");
    }
}
