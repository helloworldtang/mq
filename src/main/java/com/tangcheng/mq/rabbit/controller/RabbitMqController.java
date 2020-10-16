package com.tangcheng.mq.rabbit.controller;

import com.tangcheng.mq.global.domain.dto.ResultDTO;
import com.tangcheng.mq.rabbit.domain.req.MsgReq;
import com.tangcheng.mq.rabbit.service.RabbitMqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "RabbitMQ")
@RestController
public class RabbitMqController {

    @Autowired
    private RabbitMqService rabbitMqService;

    @ApiOperation("发送MQ消息")
    @PostMapping("/mq/rabbit/msg")
    public ResultDTO<String> sendMsg(@RequestBody MsgReq msg, @ApiParam("发送MQ消息类型.true:JSON格式，false:plain/text格式") @RequestParam(defaultValue = "false") Boolean json) {
        rabbitMqService.sendMsg(msg, json);
        return ResultDTO.ok();
    }


}
