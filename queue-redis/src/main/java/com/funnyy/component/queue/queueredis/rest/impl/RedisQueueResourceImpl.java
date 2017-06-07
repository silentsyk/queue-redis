package com.funnyy.component.queue.queueredis.rest.impl;

import com.funnyy.component.queue.queueapi.annotation.Resource;
import com.funnyy.component.queue.queueapi.model.SendModel;
import com.funnyy.component.queue.queueapi.rest.RedisQueueResource;
import com.funnyy.component.queue.queueredis.service.RedisService;
import com.funnyy.component.queue.queueredis.util.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sky on 17-5-18.
 *
 */
@Resource
@Component
public class RedisQueueResourceImpl implements RedisQueueResource{
    private final static Logger logger= LoggerFactory.getLogger(RedisQueueResourceImpl.class);

    @Qualifier(value = "list")
    @Autowired
    private RedisService redisService;

    @Autowired
    private Serializer serializer;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier(value = "compatibleRestTemplate")
    private RestTemplate restTemplate2;

    @Override
    public boolean sendMessage(SendModel sendModel) {
        logger.info(serializer.serialize(sendModel));
        redisService.get("a");
        return false;
    }

    @Override
    public String getMessage(String queueName) {
        return null;
    }

    @Override
    public String test() {
        String test=restTemplate.getForObject("https://127.0.0.1:8520/queue/redis/ssl/test/abc",String.class);
        logger.info("{}",test);
        String test2=restTemplate2.getForObject("https://127.0.0.1:8520/queue/redis/ssl/test/abc",String.class);
        logger.info("{}",test2);
        return null;
    }

    @Override
    public String testServer(String name) {
        logger.info("test {}",name);
        return "hello";
    }
}
