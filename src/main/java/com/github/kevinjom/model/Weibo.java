package com.github.kevinjom.model;

public class Weibo {
    private final String content;

    public Weibo(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Weibo{" +
                "content='" + content + '\'' +
                '}';
    }
}
