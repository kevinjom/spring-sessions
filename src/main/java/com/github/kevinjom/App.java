package com.github.kevinjom;

import com.github.kevinjom.config.AppConfigruation;
import com.github.kevinjom.http.HttpClient;
import com.github.kevinjom.http.MyHttpClient;
import com.github.kevinjom.service.MessagePoster;
import com.github.kevinjom.service.TwitterService;
import com.github.kevinjom.service.WeiboService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {
    public static void main(String[] args) {

        //postWithoutContainers();

//        postWithBeanFactory();
//        postWithApplicationContext();

        postWithJavaConfigContext();
    }

    public static void postWithoutContainers() {
        HttpClient client = new MyHttpClient();

        TwitterService twitterService = new TwitterService();
        twitterService.setHttpClient(client);

        WeiboService weiboService = new WeiboService(client);

        MessagePoster poster = new MessagePoster(twitterService, weiboService);
        poster.post("hello old java");
    }

    public static void postWithApplicationContext() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        MessagePoster messagePoster = applicationContext.getBean(MessagePoster.class);
        messagePoster.post("hello app ctxt");
    }

    public static void postWithBeanFactory() {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        MessagePoster messagePoster = beanFactory.getBean(MessagePoster.class);
        messagePoster.post("hello bean facotry");
    }

    public static void postWithJavaConfigContext() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigruation.class);
        MessagePoster messagePoster = applicationContext.getBean(MessagePoster.class);
        messagePoster.post("hello java config app ctxt");
    }
}
