package com.amrni.sport.shop.config;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.amrni.sport.shop.exception.MyRuntimeException;
import com.google.common.collect.Maps;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@Component
@RequiredArgsConstructor
public class GlobalRestControllerException {

    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception e) {
        log.error("exception -- error log，{}", e.getMessage(), e);
        Map<String, String> map = Maps.newHashMap();
        map.put("sucess", "falie");
        return map;
    }

    @ExceptionHandler(value = MyRuntimeException.class)
    public Map errorHandler1(Exception e) {
        log.error("exception -- error log，{}", e.getMessage(), e);
        Map<String, String> map = Maps.newHashMap();
        map.put("sucesss", "truesss");
        return map;
    }

}
