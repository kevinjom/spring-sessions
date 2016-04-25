package com.github.kevinjom.service;

import com.github.kevinjom.model.Tweet;
import com.github.kevinjom.model.Weibo;

public class MessagePoster {
    private final TweetService tweetService;
    private final WeiboService weiboService;

    public MessagePoster(TweetService tweetService, WeiboService weiboService) {
        this.tweetService = tweetService;
        this.weiboService = weiboService;
    }

    public boolean post(String content) {
        return tweetService.post(new Tweet(content)) && weiboService.post(new Weibo(content));
    }

}
