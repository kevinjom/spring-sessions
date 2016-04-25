package com.github.kevinjom.service;

import com.github.kevinjom.http.HttpClient;
import com.github.kevinjom.model.Weibo;

public class WeiboService {
    private final HttpClient httpClient;

    public WeiboService(HttpClient httpClient) {
        System.out.println("creating ws...");
        this.httpClient = httpClient;
    }

    public boolean post(Weibo tweet) {
        return httpClient.post("weibo.com/me", tweet).equals("ok");
    }
}
