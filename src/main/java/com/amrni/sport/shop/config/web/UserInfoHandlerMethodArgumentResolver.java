package com.amrni.sport.shop.config.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.amrni.sport.shop.common.Constant;
import com.amrni.sport.shop.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserInfoHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    public UserInfoHandlerMethodArgumentResolver() {
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        return parameter.getParameterType().equals(User.class);
    }


    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);

        User userInfo=((User) request.getAttribute(Constant.USERINFO));
        return userInfo;
    }


}
