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
import org.springframework.util.StringUtils;
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

    @Override
    public boolean sendMessage(SendModel sendModel) {
        if(StringUtils.isEmpty(sendModel.getMessage())||StringUtils.isEmpty(sendModel.getQueueName())){
            return false;
        }
        logger.info("write message to queue [{}],messages [{}]",sendModel.getQueueName(),sendModel.getMessage());
        return redisService.add(sendModel.getQueueName(),sendModel.getMessage());
    }

    @Override
    public String getMessage(String queueName) {
        String message=(String) redisService.get(queueName);
        if(message==null){
            return null;
        }
        logger.info("read message from queue [{}],message [{}]",queueName,message);
        return message;
    }

}
