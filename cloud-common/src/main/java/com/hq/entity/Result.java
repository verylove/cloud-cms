package com.hq.entity;

import com.hq.enums.ResultEnum;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author Administrator
 * @Package com.hq.entity
 * @Description: 返回实体类
 * @date 2018/4/17 10:31
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 返回编码
     */
    private String respCode;
    /**
     * 返回描述
     */
    private String respDesc;

    /**
     * 返回实体数据
     */
    private T respData;

    public Result() {
    }

    public Result(String respCode, String respDesc) {
        this.respCode = respCode;
        this.respDesc = respDesc;
    }


    public Result(String respCode, String respDesc, T respData) {
        this.respCode = respCode;
        this.respCode = respDesc;
        this.respData = respData;
    }

    public static <T> Result<T> returnOk(T t) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getDesc(), t);
    }

    public static <T> Result<T> returnFail(T t) {
        return new Result<>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getDesc(), t);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}