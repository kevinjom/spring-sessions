package com.github.kevinjom.model;

public class Tweet {
    private final String content;

    public Tweet(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "content='" + content + '\'' +
                '}';
    }
}
