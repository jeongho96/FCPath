package org.delivery.api.config.web;

import lombok.RequiredArgsConstructor;
import org.delivery.api.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    // 회원만 접속 가능한 url을 별도로 관리(인증을 필요)
    private final AuthorizationInterceptor authorizationInterceptor;

    // OPEN_API, DEFAULT, SWAGGER 제외하고 접근 시 검증 필요
    private List<String> OPEN_API = List.of(
            "/open-api/**"
    );

    private List<String> DEFAULT_EXCLUDE = List.of(
      "/",
      "favicon.ico",
      "/error"
    );

    // SWAGGER 관련 URL
    private List<String> SWAGGER = List.of(
            "/swagger-ui.html",
            "/swagger-ui/**",
            "v3/api-docs/**"
    );

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor)
                .excludePathPatterns(DEFAULT_EXCLUDE)
                .excludePathPatterns(OPEN_API)
                .excludePathPatterns(SWAGGER)
        ;
    }
}
