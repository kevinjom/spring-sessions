package com.github.kevinjom.service;

import com.github.kevinjom.http.HttpClient;
import com.github.kevinjom.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service
public class TwitterService {
    private HttpClient httpClient;

    public boolean post(Tweet tweet) {
        return httpClient.post("twitter.com/me", tweet).equals("ok");
    }

    @Autowired
    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
}
