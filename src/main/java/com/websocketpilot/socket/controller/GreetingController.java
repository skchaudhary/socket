package com.websocketpilot.socket.controller;

import com.websocketpilot.socket.model.Greeting;
import com.websocketpilot.socket.model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.logging.Logger;

@Controller
public class GreetingController {

    private static final Logger logger = Logger.getLogger(GreetingController.class.getName());

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage helloMessage) throws InterruptedException {
        logger.info("Message: " + helloMessage);
        Thread.sleep(1000);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(helloMessage.getName()) + "!");
    }
}
