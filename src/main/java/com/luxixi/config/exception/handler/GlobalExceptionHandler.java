package com.luxixi.config.exception.handler;

import com.luxixi.common.enums.ResultEnum;
import com.luxixi.common.result.Result;
import com.luxixi.config.exception.GlobalException;
import com.luxixi.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.nio.file.AccessDeniedException;

/**
 * 全局异常处理
 *
 * @author xiaoyu
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(com.luxixi.config.exception.handler.GlobalExceptionHandler.class);


    /**
     * 处理请求方式(get,post,delete,put等)错误的异常
     *
     * @return
     */
    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public @ResponseBody
    Result handlerException(HttpRequestMethodNotSupportedException ex) {
        logger.error("请求方法类型错误 Method = {}, Message = {}", ex.getMethod(), ex.getMessage());
        ex.printStackTrace();
        return ResultUtil.error(ResultEnum.REQUEST_TYPE_ERROR);
    }

    /**
     * 处理请求URL缺少必要参数的异常
     *
     * @return
     */
    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public @ResponseBody
    Result handlerException(MissingServletRequestParameterException ex) {
        logger.error("请求参数错误 ParameterName = {}, Message = {}", ex.getParameterName(), ex.getMessage());
        ex.printStackTrace();
        return ResultUtil.error(ResultEnum.PARAM_ERROR);
    }

    /**
     * 处理参数类型异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class})
    public @ResponseBody
    Result handlerException(MethodArgumentTypeMismatchException ex) {
        logger.error("请求参数错误 MethodParameter = {}, Message = {}", ex.getParameter(), ex.getMessage());
        ex.printStackTrace();
        return ResultUtil.error(ResultEnum.PARAM_TYPE_ERROR);
    }

    /**
     * 权限校验异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {AccessDeniedException.class})
    public @ResponseBody
    Result handlerException(AccessDeniedException ex) {
        logger.error("权限校验异常 MethodParameter = {}, Message = {}", ex.getStackTrace(), ex.getMessage());
        ex.printStackTrace();
        return ResultUtil.error(ex.getMessage());
    }

    /**
     * 全局异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {GlobalException.class})
    public @ResponseBody
    Result handlerException(GlobalException ex) {
        logger.error("全局异常处理 Exception Status = {}, Message = {}", ex.getStatus(), ex.getMessage());
        ex.printStackTrace();
        return ResultUtil.error(ex.getStatus(), ex.getMessage());
    }

    /**
     * 统一异常处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public @ResponseBody
    Result handlerException(Exception ex) {
        logger.error("统一异常处理 StackTrace = {}, Message = {}", ex.getStackTrace(), ex.getMessage());
        ex.printStackTrace();
        return ResultUtil.error(ResultEnum.REQUEST_OPERATION_ERROR);
    }

    /**
     * 方法参数校验
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public @ResponseBody
    Result handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error("方法参数校验 StackTrace = {}, Message = {}", ex.getStackTrace(), ex.getMessage());
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        ex.printStackTrace();
        return ResultUtil.error(ResultEnum.PARAM_ERROR_NULL.getStatus(), message);
    }

    /**
     * 数据约束违反异常
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    public @ResponseBody
    Result handleConstraintViolationException(ConstraintViolationException ex) {
        logger.error("数据约束违反异常 StackTrace = {}, Message = {}", ex.getStackTrace(), ex.getMessage());
        ex.printStackTrace();
        return ResultUtil.error(ResultEnum.VALIDATION_CODE.getStatus(), ex.getMessage());
    }
}
