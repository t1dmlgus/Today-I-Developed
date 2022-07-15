package com.t1dmlgus.ordermvp.common.config;

import com.t1dmlgus.ordermvp.common.iterceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/v1/signin", "/api/v1/signup", "/api/v1/logout");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
