package com.amrni.sport.shop.config;

import java.util.Map;

import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.amrni.sport.shop.common.ApiResponse;
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
    public ApiResponse errorHandler(Exception e) {
        log.error("exception -- error log，{}", e.getMessage(), e);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(e.getMessage());
        apiResponse.setSuccess(false);
        return apiResponse;
    }

    @ExceptionHandler(value = MyRuntimeException.class)
    public ApiResponse errorHandler1(Exception e) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(e.getMessage());
        apiResponse.setSuccess(false);
        return apiResponse;
    }

}
