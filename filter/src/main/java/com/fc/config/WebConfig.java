package com.fc.config;

import com.fc.filter.interceptor.OpenApiInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private OpenApiInterceptor openApiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 들어오는 모든 주소에 대해서 openApiInterceptor를 적용한다.
//        registry.addInterceptor(openApiInterceptor)
//                .addPathPatterns("/**");
    }
}
