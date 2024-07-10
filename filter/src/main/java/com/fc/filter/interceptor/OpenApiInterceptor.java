package com.fc.filter.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class OpenApiInterceptor implements HandlerInterceptor {
    // 3가지 메서드
    // preHandle : True면 controller로 전달, 아니면 X
    // postHandle : Model And View가 호출
    // afterCompletion : 이름처럼 완료 시 호출

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       log.info("pre handle");

       var handlerMethod = (HandlerMethod) handler;

       // 메소드가 OpenApi 어노테이션이 있으면 통과
       var methodLevel = handlerMethod.getMethodAnnotation(OpenApi.class);
       if (methodLevel != null) {
           log.info("method level is " + methodLevel);
           return true;
       }

       var classLevel = handlerMethod.getBeanType().getAnnotation(OpenApi.class);
       if (classLevel != null) {
           log.info("class level is " + classLevel);
           return true;
       }

       log.info("open API XX");
       return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
