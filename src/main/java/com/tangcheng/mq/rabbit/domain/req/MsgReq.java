package com.tangcheng.mq.rabbit.domain.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel("请求的消息")
@Data
public class MsgReq {

    private String id;

    private String content;

}
