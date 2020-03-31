package com.tangcheng.mq.rabbit.config;

import lombok.Getter;

import static com.tangcheng.mq.rabbit.config.RabbitBizConfig.QUEUES_TEST;

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
    TEST("测试队列", "exchanges.test", "routing_keys.test", QUEUES_TEST);

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
