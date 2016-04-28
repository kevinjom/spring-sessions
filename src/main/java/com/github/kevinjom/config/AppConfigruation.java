package com.github.kevinjom.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Arrays;

@Configuration
@ComponentScan("com.github.kevinjom")
public class AppConfigruation {

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public EmbeddedServletContainerFactory jettyServletContainerFactory() {
        JettyEmbeddedServletContainerFactory jetty = new JettyEmbeddedServletContainerFactory();
        jetty.setPort(8081);
        return jetty;
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet());
        registrationBean.setLoadOnStartup(0);
        registrationBean.setUrlMappings(Arrays.asList("/"));
        return registrationBean;
    }
}
