package com.github.kevinjom.service;

import com.github.kevinjom.http.HttpClient;
import com.github.kevinjom.model.Weibo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeiboService {
    private final HttpClient httpClient;

    @Autowired
    public WeiboService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public boolean post(Weibo tweet) {
        return httpClient.post("weibo.com/me", tweet).equals("ok");
    }
}
