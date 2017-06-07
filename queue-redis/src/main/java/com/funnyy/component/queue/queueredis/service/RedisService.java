package com.funnyy.component.queue.queueredis.service;

/**
 * Created by sky on 17-5-18.
 */
public interface RedisService {
    boolean add(Object key,Object value);

    Object get(Object key);

    boolean del(Object key);


}
