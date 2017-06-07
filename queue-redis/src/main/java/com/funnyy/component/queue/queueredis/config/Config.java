package com.funnyy.component.queue.queueredis.config;

import com.funnyy.component.queue.queueredis.util.JacksonSerializer;
import com.funnyy.component.queue.queueredis.util.Serializer;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sky on 17-5-12.
 *
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages={
    "com.funnyy.component.queue.queueredis.*",
})
@Import({
    com.funnyy.component.queue.queueredis.config.RedisConfig.class,
})
public class Config {
    @Bean
    public Serializer serializer(){
        return new JacksonSerializer();
    }

    @Bean
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory factory=new HttpComponentsClientHttpRequestFactory();
        factory.setConnectionRequestTimeout(100000);
        factory.setReadTimeout(100000);
        return new RestTemplate(factory);
    }

    @Bean(name = "compatibleRestTemplate")
    public RestTemplate restTemplateCompatible(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(100000);//ms
        factory.setConnectTimeout(100000);//ms
        return new RestTemplate(factory);
    }

//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//        JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
//        factory.setPort(9999);
//        factory.setContextPath("/test");
//        return factory;
//    }

//    @Bean
//    public Connector httpConnector(){//2
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setPort(9090);
//        connector.setSecure(false);
//        connector.setRedirectPort(8443);
//        return connector;
//    }
}
