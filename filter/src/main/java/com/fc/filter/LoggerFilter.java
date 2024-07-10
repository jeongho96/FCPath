package com.fc.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.stream.Collectors;

// 다른 곳이 아니라 servlet의 필터를 가져와야 한다.
@Slf4j
@Component
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        log.info("진입 전");

        var req = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        var res = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        filterChain.doFilter(req, res);

        // 원래 로직인 doFIlter가 끝나고 확인해야 함.

        var reqjson = new String(req.getContentAsByteArray());
        log.info("{}", reqjson);

        var resjson = new String(res.getContentAsByteArray());
        log.info("{}", resjson);

        // 캐시에 있던 값을 읽어버렸기 때문에 보낼 값이 없어졌으므로 그 값을
        // 다시 적어서 넣어줘야 함.
        res.copyBodyToResponse();


        log.info("진입 후");
    }
}
