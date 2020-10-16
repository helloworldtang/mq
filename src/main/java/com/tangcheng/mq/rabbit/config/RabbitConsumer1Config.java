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
public class RabbitConsumer1Config {

    public static final String QUEUES_CONSUMER_1 = "queues.consumer.1";


    @Bean
    public Queue consumer1Queue() {
        return QueueBuilder.durable(RabbitMQEnum.Consumer1.getQueue()).build();
    }

    @Bean
    public TopicExchange consumer1TopicExchange() {
        return ExchangeBuilder.topicExchange(RabbitMQEnum.Consumer1.getExchange()).build();
    }

    @Bean
    public Binding consumer1Binding(Queue consumer1Queue, TopicExchange consumer1TopicExchange) {
        return BindingBuilder.bind(consumer1Queue).to(consumer1TopicExchange).with(RabbitMQEnum.Consumer1.getRoutingKey());
    }


}
