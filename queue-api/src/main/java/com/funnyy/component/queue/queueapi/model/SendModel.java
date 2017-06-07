package com.funnyy.component.queue.queueapi.model;

/**
 * Created by sky on 17-5-18.
 */
public class SendModel {
    String queueName;
    String message;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
