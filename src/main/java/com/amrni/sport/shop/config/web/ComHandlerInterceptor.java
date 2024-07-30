package com.amrni.sport.shop.config.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.amrni.sport.shop.command.JwtUtil;
import com.amrni.sport.shop.common.Constant;
import com.amrni.sport.shop.jpa.UserJpa;
import com.amrni.sport.shop.model.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ComHandlerInterceptor implements HandlerInterceptor {

    private final UserJpa userJpa;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contentType = request.getContentType();
        log.debug("ThirdPart_开始鉴权,{}", handler);
        log.debug("ThirdPart_请求ContentType,{}", contentType);

        if(request.getRequestURL().toString().contains("login")){
            return true;
        }
        String authorization = request.getHeader("Authorization");
        Map<String, Object> map = JwtUtil.decodeToken(authorization);
        Integer integer = Integer.valueOf(map.get("id").toString());
        User user = userJpa.findById(integer).get();
        request.setAttribute(Constant.USERINFO,user);

        return true;
    }

}

