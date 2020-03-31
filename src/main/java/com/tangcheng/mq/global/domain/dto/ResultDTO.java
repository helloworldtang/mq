package com.tangcheng.mq.global.domain.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tangcheng.mq.global.domain.dto.base.BizError;
import com.tangcheng.mq.global.exception.DefaultCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

/**
 * ResultDTO需定义到common-api顶层二方库，这样以来各个应用不需要来回转换返回结果
 *
 * @author: cheng.tang
 * @date: 2020/3/30
 * @see
 * @since
 */
@ToString
public class ResultDTO<T> implements BizError {

    @JSONField(serialize = false, deserialize = false)
    @JsonIgnore
    private transient BizError bizError;

    /**
     * 错误码
     */
    @Setter
    private Integer errCode;

    /**
     * 错误消息
     */
    private String errMsg;

    /**
     * 表示返回的结果集
     */
    @Getter
    @Setter
    private T data;

    /**
     * 代表接口处理响应结果成功还是失败
     * true:成功；false:失败
     */
    @Getter
    private Boolean success;

    public ResultDTO() {
        this.setBizError(DefaultCodeEnum.SUCCESS);
    }

    /**
     * 成功的请求
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultDTO<T> ok(T data) {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setData(data);
        resultDTO.setBizError(DefaultCodeEnum.SUCCESS);
        return resultDTO;
    }

    /**
     * 成功的请求
     *
     * @param <T>
     * @return
     */
    public static <T> ResultDTO<T> ok() {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setBizError(DefaultCodeEnum.SUCCESS);
        return resultDTO;
    }

    /**
     * 异常的请求
     *
     * @return
     */
    public static ResultDTO<String> fail() {
        ResultDTO<String> resultDTO = new ResultDTO<>();
        resultDTO.setBizError(DefaultCodeEnum.FAIL.setErrMsg("未知异常"));
        return resultDTO;
    }

    /**
     * 异常的请求
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResultDTO<T> fail(String msg) {
        return ResultDTO.fail(DefaultCodeEnum.FAIL.setErrMsg(msg));
    }

    /**
     * 异常的请求
     *
     * @param bizError
     * @param <T>
     * @return
     */
    public static <T> ResultDTO<T> fail(BizError bizError) {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setBizError(bizError);
        return resultDTO;
    }

    /**
     * 异常的请求，有返回数据
     *
     * @param bizError
     * @param data
     * @return
     */
    public static <T> ResultDTO<T> fail(BizError bizError, T data) {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setBizError(bizError);
        resultDTO.setData(data);
        return resultDTO;
    }

    public void setBizError(BizError bizError) {
        this.bizError = bizError;
        if (bizError != null) {
            this.setErrCode(bizError.getErrCode());
            this.errMsg = bizError.getErrMsg();
            this.success = Objects.equals(this.bizError, DefaultCodeEnum.SUCCESS);
        }
    }

    /**
     * 500:失败；200:成功
     *
     * @return
     */
    @Override
    public Integer getErrCode() {
        return this.errCode;
    }

    /**
     * 接口返回数据的描述信息
     *
     * @return
     */
    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public BizError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return bizError;
    }


}
