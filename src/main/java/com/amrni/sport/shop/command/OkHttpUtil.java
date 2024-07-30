package com.amrni.sport.shop.command;

import java.io.IOException;
import java.util.Map;
import java.util.StringJoiner;

import com.amrni.sport.shop.exception.MyRuntimeException;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Slf4j
public class OkHttpUtil {

    private static final OkHttpClient client = new OkHttpClient();

    public static String sendGetRequest(String baseUrl, Map<String, String> params) throws IOException {
        StringJoiner urlBuilder = new StringJoiner("&", baseUrl + "?", "");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            urlBuilder.add(entry.getKey() + "=" + entry.getValue());
        }

        Request request = new Request.Builder()
                .url(urlBuilder.toString())
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new MyRuntimeException("Request failed: " + response.message());
            }
        }
    }

}