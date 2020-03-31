package com.tangcheng.mq.rabbit.service.impl;

import com.alibaba.fastjson.JSON;
import com.tangcheng.mq.rabbit.config.RabbitMQEnum;
import com.tangcheng.mq.rabbit.service.RabbitMqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

/**
 * @author: cheng.tang
 * @date: 2020/3/30
 * @see
 * @since
 */
@Service
@Slf4j
public class RabbitMqServiceImpl implements RabbitMqService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMsg(Object msg, Boolean json) {
        if (json) {
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setContentType(MediaType.APPLICATION_JSON_VALUE);
            Message message = new Message(msg.toString().getBytes(), messageProperties);
            amqpTemplate.convertAndSend(RabbitMQEnum.TEST.getExchange(), RabbitMQEnum.TEST.getRoutingKey(), message);
            return;
        }
        amqpTemplate.convertAndSend(RabbitMQEnum.TEST.getExchange(), RabbitMQEnum.TEST.getRoutingKey(), JSON.toJSONString(msg));
    }


}
