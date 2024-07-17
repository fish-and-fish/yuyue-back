package com.amrni.sport.shop.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.amrni.sport.shop.exception.MyRuntimeException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ThirdPartyHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contentType = request.getContentType();
        log.debug("ThirdPart_开始鉴权,{}", handler);
        log.debug("ThirdPart_请求ContentType,{}", contentType);

        throw new MyRuntimeException("error");
    }

}

