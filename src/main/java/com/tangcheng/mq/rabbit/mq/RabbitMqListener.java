package com.tangcheng.mq.rabbit.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import static com.tangcheng.mq.rabbit.config.RabbitBizConfig.QUEUES_TEST;

/**
 * @author: cheng.tang
 * @date: 2020/3/30
 * @see
 * @since
 */
@Slf4j
@Service
public class RabbitMqListener {

    @RabbitListener(queues = QUEUES_TEST)
    public void listening(String msg,
                          @Header(AmqpHeaders.CONTENT_TYPE) String contentType) {
        log.info("msg:{} contentType:{}", msg, contentType);
        //业务代码
    }


}
