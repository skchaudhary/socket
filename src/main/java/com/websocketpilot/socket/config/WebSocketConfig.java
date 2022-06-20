package com.websocketpilot.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.logging.Logger;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private static final Logger logger = Logger.getLogger(WebSocketConfig.class.getName());

    public void registerStompEndpoints(StompEndpointRegistry registry) {
        logger.info("Registering the web-socket end-point: gs-guide-websocket");
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        logger.info("Configuring the enable simple broker prefix as /topic where messages will be published.");
        config.enableSimpleBroker("/topic");
        logger.info("Configuring the application destination prefixes which will be used to hit the end-point from our controller.");
        config.setApplicationDestinationPrefixes("/app");
    }
}
