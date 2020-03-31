package com.tangcheng.mq.rabbit.controller;

import com.tangcheng.mq.global.domain.dto.ResultDTO;
import com.tangcheng.mq.rabbit.service.RabbitMqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cheng.tang
 * @date: 2020/3/30
 * @see
 * @since
 */
@RestController
public class RabbitMqController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @PostMapping("/mq/rabbit/msg")
    public ResultDTO<String> sendMsg(@RequestBody Object msg, @RequestParam(defaultValue = "false") Boolean json) {
        rabbitMqService.sendMsg(msg, json);
        return ResultDTO.ok();
    }


}
