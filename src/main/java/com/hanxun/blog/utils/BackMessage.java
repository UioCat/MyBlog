package com.hanxun.blog.utils;

import com.hanxun.blog.enums.BackEnum;

/**
 * @author uio
 */
public class BackMessage<T> {

    private Integer code;
    private String message;
    private T info;

    public BackMessage(BackEnum backEnum){
        this.code=backEnum.getCode();
        this.message=backEnum.getMessage();
    }

    public BackMessage(BackEnum backEnum, T t){
        this.code=backEnum.getCode();
        this.message=backEnum.getMessage();
        this.info=t;
    }

    public BackMessage(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public BackMessage(String message){
        this.code = 200;
        this.message = message;
    }

    public static BackMessage success() {
        return new BackMessage(BackEnum.REQUEST_SUCCESS);
    }

    public static BackMessage error(){
        return new BackMessage(BackEnum.UNKNOWN_ERROR);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
