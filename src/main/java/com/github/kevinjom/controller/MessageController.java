package com.github.kevinjom.controller;

import com.github.kevinjom.service.MessagePoster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
    private final MessagePoster messagePoster;

    @Autowired
    public MessageController(MessagePoster messagePoster) {
        this.messagePoster = messagePoster;
    }

    @RequestMapping("/msg/{content}")
    @ResponseBody
    public String postMsg(@PathVariable String content) {
        if (messagePoster.post(content)) {
            return "yes, pushed :" + content;
        } else {
            return "oooooooops...";
        }
    }
}
