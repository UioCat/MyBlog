package com.hanxun.blog.handle;

import com.hanxun.blog.enums.BackEnum;
import com.hanxun.blog.exception.CustomException;
import com.hanxun.blog.utils.BackMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

/**
 * @author uio
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BackMessage handle(Exception e) {

        if(e instanceof CustomException) {
            CustomException customException = (CustomException) e;
            logger.warn("自定义异常捕获:{}", customException.getErrorMsg());
            return new BackMessage(customException.getErrorCode(), customException.getErrorMsg());
        } else if(e instanceof HttpRequestMethodNotSupportedException) {
            logger.warn("捕捉浏览器错误请求异常");
            return new BackMessage(BackEnum.REQUEST_METHOD_ERROR);
        } else if(e instanceof MissingServletRequestParameterException) {
            logger.warn("捕捉错误参数请求异常");
            return new BackMessage(BackEnum.PARAM_ERROR);
        } else if(e instanceof HttpMessageNotReadableException) {
            logger.warn("捕捉错误JSON请求有数据异常");
            return new BackMessage(BackEnum.DATA_ERROR);
        } else if(e instanceof DuplicateKeyException) {
            logger.warn("主键重复添加");
            return new BackMessage(BackEnum.REPETITION);
        } else if(e instanceof HttpMediaTypeNotSupportedException) {
            logger.warn("数据类型错误,json<->form-urlencoded");
            return new BackMessage(BackEnum.MEDIA_TYPE_ERROR);
        }
        else {
            e.printStackTrace();
            logger.error("系统异常{}",e);
            return new BackMessage(BackEnum.UNKNOWN_ERROR);
        }


    }


}