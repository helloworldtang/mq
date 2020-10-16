package com.tangcheng.mq.rabbit.config;

import lombok.Getter;

import static com.tangcheng.mq.rabbit.config.RabbitConsumer1Config.QUEUES_CONSUMER_1;
import static com.tangcheng.mq.rabbit.config.RabbitConsumer2Config.QUEUES_CONSUMER_2;

/**
 * @author: cheng.tang
 * @date: 2020/3/30
 * @see
 * @since
 */
@Getter
public enum RabbitMQEnum {
    /**
     * 队列数据统一管理
     */
    Consumer1("测试队列1", "exchanges.test", "routing_keys.test", QUEUES_CONSUMER_1),
    Consumer2("测试队列2", "exchanges.test", "routing_keys.test", QUEUES_CONSUMER_2),
    ;

    private final String memo;
    private final String exchange;
    private final String routingKey;
    private final String queue;

    RabbitMQEnum(String memo, String exchange, String routingKey, String queue) {
        this.memo = memo;
        this.exchange = exchange;
        this.routingKey = routingKey;
        this.queue = queue;
    }

}
