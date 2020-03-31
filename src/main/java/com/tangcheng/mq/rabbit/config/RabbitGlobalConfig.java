package com.tangcheng.mq.rabbit.config;

import org.springframework.amqp.support.converter.ContentTypeDelegatingMessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

/**
 * @author: cheng.tang
 * @date: 2020/3/31
 * @see
 * @since
 */
@Configuration
public class RabbitGlobalConfig {

//    @Bean
    public MessageConverter messageConverter() {
        ContentTypeDelegatingMessageConverter messageConverter = new ContentTypeDelegatingMessageConverter();
        messageConverter.addDelegate(MediaType.APPLICATION_JSON_VALUE, new Jackson2JsonMessageConverter());
        messageConverter.addDelegate(MediaType.TEXT_PLAIN_VALUE, new SimpleMessageConverter());
        return messageConverter;
    }

}
