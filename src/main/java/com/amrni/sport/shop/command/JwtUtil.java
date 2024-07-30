package com.amrni.sport.shop.command;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.amrni.sport.shop.exception.MyRuntimeException;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;

public class JwtUtil {

    private static final byte[] SECRET = "mdfi30e93joi2".getBytes(); // Use a secure key

    public static String generateToken(String id) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
//        payload.put("username", username);
//        payload.put("email", email);

        return JWTUtil.createToken(payload, SECRET);
    }

    public static Map<String, Object> decodeToken(String token) {
        if(!StringUtils.hasText(token)){
            throw new MyRuntimeException("未登录，请求失败");
        }
        JWT jwt = JWTUtil.parseToken(token);
        if (jwt.setKey(SECRET).verify()) {
            return jwt.getPayloads();
        } else {
            return null;
        }
    }

}
