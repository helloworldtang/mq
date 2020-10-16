package com.tangcheng.mq.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: cheng.tang
 * @date: 2020/3/30
 * @see
 * @since
 */
@Configuration
public class RabbitConsumer2Config {

    public static final String QUEUES_CONSUMER_2 = "queues.consumer.2";


    @Bean
    public Queue consumer2Queue() {
        return QueueBuilder.durable(RabbitMQEnum.Consumer2.getQueue()).build();
    }

    @Bean
    public TopicExchange consumer2TopicExchange() {
        return ExchangeBuilder.topicExchange(RabbitMQEnum.Consumer2.getExchange()).build();
    }

    @Bean
    public Binding consumer2Binding(Queue consumer2Queue, TopicExchange consumer2TopicExchange) {
        return BindingBuilder.bind(consumer2Queue).to(consumer2TopicExchange).with(RabbitMQEnum.Consumer2.getRoutingKey());
    }


}
