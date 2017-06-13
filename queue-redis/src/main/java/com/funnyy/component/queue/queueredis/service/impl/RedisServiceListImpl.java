package com.funnyy.component.queue.queueredis.service.impl;

import com.funnyy.component.queue.queueredis.rest.impl.RedisQueueResourceImpl;
import com.funnyy.component.queue.queueredis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by sky on 17-5-18.
 * for redis list
 */
@Service(value = "list")
public class RedisServiceListImpl implements RedisService{

    private final static Logger logger= LoggerFactory.getLogger(RedisQueueResourceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${redis.hold.wait}")
    private long second;

    @Override
    public boolean add(Object key, Object value) {
        ListOperations<String,String> listOperations=redisTemplate.opsForList();
        long count=listOperations.rightPush((String )key,(String )value);
        if (count == 0) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Object get(Object key) {
        ListOperations<String,String> listOperations=redisTemplate.opsForList();
        String value=listOperations.leftPop((String) key,second, TimeUnit.SECONDS);
        return value;
    }

    @Override
    public boolean del(Object key) {
        return false;
    }
}
