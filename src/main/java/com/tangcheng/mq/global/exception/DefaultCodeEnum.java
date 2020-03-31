package com.tangcheng.mq.global.exception;

import com.tangcheng.mq.global.domain.dto.base.BizError;
import lombok.Getter;

/**
 * @author: cheng.tang
 * @date: 2020/3/30
 * @see
 * @since
 */
@Getter
public enum DefaultCodeEnum implements BizError {
    /**
     * 将可预知的高频场景初始化一下
     */
    SUCCESS(200, ""),
    FAIL(500, "出现未知异常"),
    BAD_REQUEST(400, "参数错误"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_EXIST(404, "资源不存在"),
    DUPLICATION(600, "数据已存在"),
    INVALID_DATA(601, "数据无效"),
    ;

    private final int errCode;
    private String errMsg;

    DefaultCodeEnum(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public Integer getErrCode() {
        return errCode;
    }

    @Override
    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public BizError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }


}
