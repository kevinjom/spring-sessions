package com.github.kevinjom.factory;

import com.github.kevinjom.http.HttpClient;
import com.github.kevinjom.http.MyHttpClient;
import org.springframework.beans.factory.config.AbstractFactoryBean;

public class HttpClientFactoryBean extends AbstractFactoryBean<HttpClient> {
    @Override
    public Class<?> getObjectType() {
        return HttpClient.class;
    }

    @Override
    protected HttpClient createInstance() throws Exception {
        return new MyHttpClient();
    }
}
