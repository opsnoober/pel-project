package com.luxixi.exception;


import cn.hutool.http.HttpStatus;
import com.luxixi.common.enums.ResultEnum;

/**
 * 全局异常处理
 * @author xiaoyu
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 8247610319171014183L;

    private Integer status;

    private String message;

    public GlobalException(String message) {
        super(message);
        this.message = message;
        this.status = HttpStatus.HTTP_INTERNAL_ERROR;
    }

    public GlobalException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.status = resultEnum.getStatus();
        this.message = resultEnum.getMessage();
    }

    public GlobalException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
        this.status = HttpStatus.HTTP_INTERNAL_ERROR;
    }

    public GlobalException(Integer status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public GlobalException(Integer status, String message, Throwable throwable) {
        super(message, throwable);
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
