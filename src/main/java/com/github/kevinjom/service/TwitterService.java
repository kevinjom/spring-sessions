package com.github.kevinjom.service;

import com.github.kevinjom.http.HttpClient;
import com.github.kevinjom.model.Tweet;
import org.springframework.beans.factory.annotation.Required;

public class TwitterService {
    private HttpClient httpClient;

    public boolean post(Tweet tweet) {
        return httpClient.post("twitter.com/me", tweet).equals("ok");
    }

    @Required
    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
}
