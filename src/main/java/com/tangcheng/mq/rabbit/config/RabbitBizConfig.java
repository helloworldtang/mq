package com.tangcheng.mq.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: cheng.tang
 * @date: 2020/3/30
 * @see
 * @since
 */
@Configuration
public class RabbitBizConfig {

    public static final String QUEUES_TEST = "queues.test";


    @Bean
    public Queue testQueue() {
        return QueueBuilder.durable(RabbitMQEnum.TEST.getQueue()).build();
    }

    @Bean
    public DirectExchange testDirectExchange() {
        return ExchangeBuilder.directExchange(RabbitMQEnum.TEST.getExchange()).build();
    }

    @Bean
    public Binding testBinding(Queue testQueue, DirectExchange testDirectExchange) {
        return BindingBuilder.bind(testQueue).to(testDirectExchange).with(RabbitMQEnum.TEST.getRoutingKey());
    }


}
