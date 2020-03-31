package com.tangcheng.mq.global.domain.dto.base;

/**
 * @author: cheng.tang
 * @date: 2020/3/30
 * @see
 * @since
 */
public interface BizError {

    Integer getErrCode();

    String getErrMsg();

    BizError setErrMsg(String errMsg);

}
