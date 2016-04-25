package com.github.kevinjom.service;

import com.github.kevinjom.model.Tweet;
import com.github.kevinjom.http.HttpClient;

public class TwitterService {
    private final HttpClient httpClient;

    public TwitterService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public boolean post(Tweet tweet) {
        return httpClient.post("twitter.com/me", tweet).equals("ok");
    }
}
