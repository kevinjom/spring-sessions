package com.github.kevinjom;

import com.github.kevinjom.http.HttpClient;
import com.github.kevinjom.http.MyHttpClient;
import com.github.kevinjom.service.MessagePoster;
import com.github.kevinjom.service.TweetService;
import com.github.kevinjom.service.WeiboService;

public class App {
    public static void main(String[] args) {

        postWithoutContainers();
    }

    public static  void postWithoutContainers() {
        HttpClient client = new MyHttpClient();

        TweetService tweetService = new TweetService(client);
        WeiboService weiboService = new WeiboService(client);

        MessagePoster poster = new MessagePoster(tweetService, weiboService);
        poster.post("hello spring ioc");
    }
}
