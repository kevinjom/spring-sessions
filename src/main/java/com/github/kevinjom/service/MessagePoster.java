package com.github.kevinjom.service;

import com.github.kevinjom.model.Tweet;
import com.github.kevinjom.model.Weibo;
import org.springframework.beans.factory.annotation.Autowired;

public class MessagePoster {
    private final TwitterService twitterService;
    private final WeiboService weiboService;

    @Autowired
    public MessagePoster(TwitterService twitterService, WeiboService weiboService) {
        this.twitterService = twitterService;
        this.weiboService = weiboService;
    }

    public boolean post(String content) {
        return twitterService.post(new Tweet(content)) && weiboService.post(new Weibo(content));
    }

}
