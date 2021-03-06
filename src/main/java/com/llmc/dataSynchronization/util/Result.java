package com.llmc.dataSynchronization.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 数据返回类
 * @author ZZT
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("返回类")
public class Result<T>  {
    @ApiModelProperty(example = "状态码")
    private Integer code;//状态码 成功200 失败400
    @ApiModelProperty(example = "状态")
    private Boolean isSuccess;//状态
    @ApiModelProperty(example = "消息")
    private String message;//消息
    @ApiModelProperty(example = "数据对象")
    private T data;//数据对象


    public Result(){
        super();
    }




    /*
        返回状态码，状态，消息
         */
    public Result(Integer code, Boolean isSuccess, String message) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.message=message;
    }

    /*
    返回 状态 状态码 数据
     */
    public Result(Integer code, Boolean isSuccess, T data) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.data = data;
    }

    /*
    返回全部
     */
    public Result(Integer code, Boolean isSuccess, String message, T data) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


