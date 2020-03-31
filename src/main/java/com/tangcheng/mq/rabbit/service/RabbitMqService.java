package com.tangcheng.mq.rabbit.service;

/**
 * @author: cheng.tang
 * @date: 2020/3/30
 * @see
 * @since
 */
public interface RabbitMqService {
    void sendMsg(Object msg, Boolean json);
}
