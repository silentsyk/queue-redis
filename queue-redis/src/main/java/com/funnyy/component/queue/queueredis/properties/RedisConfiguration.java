package com.funnyy.component.queue.queueredis.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sky on 17-5-18.
 */
@Configuration
public class RedisConfiguration {
    @Value("${redis.cache.server}")
    private String server;
    @Value("${redis.cache.port}")
    private int port;
    @Value("${redis.cache.password}")
    private String password;
    @Value("${redis.cache.prefix}")
    private String prefix;

    public RedisConfiguration() {
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
