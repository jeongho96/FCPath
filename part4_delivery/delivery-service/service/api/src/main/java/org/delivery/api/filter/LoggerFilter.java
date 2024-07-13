package org.delivery.api.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Slf4j
@Component
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 필터에서 미리 확인하면 확인한 값을 사라지므로 그걸 처리해줘야 함.
        var req = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);

        var res = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        // 이전에 로그를 찍으려면 별도의 WrapperClass를 만들어서 해주는게 이상적.

        // doFilter를 기준으로 이후가 실행 후, 이전이 실행 전으로 나뉨.

        filterChain.doFilter(req, res);

        // request 정보

        var headerNames = req.getHeaderNames();
        var headerValues = new StringBuilder();

        headerNames.asIterator().forEachRemaining(headerKey -> {
                        var headerValue = req.getHeader(headerKey);

                        // key : ??? (개행) key : ???
                        headerValues.append("[").append(headerKey).append(" : ").append(headerValue).append("] ");
                }
        );

        var requestBody = new String(req.getContentAsByteArray());

        var uri = req.getRequestURI();
        var method = req.getMethod();

        log.info(">>>>> uri : {}, method : {}, header : {}, body : {}", uri, method, headerValues, requestBody);

        // response 정보
        var responseHeaderValue = new StringBuilder();

        res.getHeaderNames().forEach(headerKey -> {
           var headerValue = res.getHeader(headerKey);

            // key : ??? (개행) key : ???
            responseHeaderValue.append("[").append(headerKey).append(" : ").append(headerValue).append("] ");
        });

        var responseBody = new String(res.getContentAsByteArray());

        log.info(">>>>> uri : {}, method : {}, header : {}, body : {}", uri, method, responseHeaderValue, responseBody);

        // 읽었기 때문에 반드시 복사해서 처리해줘야 함.
        // 안그러면 빈 상태로 전달됨.
        res.copyBodyToResponse();

    }
}
