package com.github.kevinjom.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.github.kevinjom")
public class AppConfigruation {

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }
}
