package com.funnyy.component.queue.queueredis.service.impl;

import com.funnyy.component.queue.queueredis.rest.impl.RedisQueueResourceImpl;
import com.funnyy.component.queue.queueredis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by sky on 17-5-18.
 * for redis list
 */
@Service(value = "list")
public class RedisServiceListImpl implements RedisService{

    private final static Logger logger= LoggerFactory.getLogger(RedisQueueResourceImpl.class);

    @Override
    public boolean add(Object key, Object value) {
        logger.info("");

        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public boolean del(Object key) {
        return false;
    }
}
