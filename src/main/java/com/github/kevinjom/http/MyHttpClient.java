package com.github.kevinjom.http;

public class MyHttpClient implements HttpClient{
    @Override
    public Object post(String url, Object body) {
        System.out.println(String.format("post to %s with body %s", url, body));
        return "ok";
    }
}
