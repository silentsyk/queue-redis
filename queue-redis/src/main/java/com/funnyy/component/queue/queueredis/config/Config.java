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
}
