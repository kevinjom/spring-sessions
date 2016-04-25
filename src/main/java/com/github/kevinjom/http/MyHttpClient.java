package com.github.kevinjom.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyHttpClient implements HttpClient {
    private final ObjectMapper objectMapper;

    @Autowired
    public MyHttpClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Object post(String url, Object body) {
        try {
            System.out.println(String.format("post to %s with body %s", url, objectMapper.writeValueAsString(body)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
