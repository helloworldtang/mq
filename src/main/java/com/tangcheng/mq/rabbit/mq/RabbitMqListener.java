package com.tangcheng.mq.rabbit.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import static com.tangcheng.mq.rabbit.config.RabbitConsumer1Config.QUEUES_CONSUMER_1;
import static com.tangcheng.mq.rabbit.config.RabbitConsumer2Config.QUEUES_CONSUMER_2;

/**
 * @author: cheng.tang
 * @date: 2020/3/30
 * @see
 * @since
 */
@Slf4j
@Service
public class RabbitMqListener {

    @RabbitListener(queues = QUEUES_CONSUMER_1)
    public void listening1(String msg,
                           @Header(AmqpHeaders.CONTENT_TYPE) String contentType) {
        log.info("[{}] msg:{} contentType:{}", QUEUES_CONSUMER_1, msg, contentType);
        //业务代码
    }


    @RabbitListener(queues = QUEUES_CONSUMER_2)
    public void listening2(String msg,
                           @Header(AmqpHeaders.CONTENT_TYPE) String contentType) {
        log.info("[{}] msg:{} contentType:{}", QUEUES_CONSUMER_2, msg, contentType);
        //业务代码
    }


}
