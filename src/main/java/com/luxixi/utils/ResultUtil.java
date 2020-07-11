package com.luxixi.utils;

import com.google.common.collect.Lists;
import com.luxixi.common.enums.ResultEnum;
import com.luxixi.common.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 统一返回工具类
 * @author xioayu
 */
public class ResultUtil {

    private static final Logger logger = LoggerFactory.getLogger(com.luxixi.utils.ResultUtil.class);

    public ResultUtil() { }

    public static Result success(Object object) {
        return new Result(ResultEnum.REQUEST_SUCCESS.getStatus(), ResultEnum.REQUEST_SUCCESS.getMessage(), object);
    }

    public static <T> Result success(Object object, Class<T> clazz) {
        if (object == null) {
            return success(object);
        } else {
            Object t;
            try {
                t = clazz.newInstance();
                BeanUtils.copyProperties(object, t);
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.error("Object copy exception {}", ex.getMessage());
                return error();
            }
            return success(t);
        }
    }

    public static <T> Result successCollection(Collection list, Class<T> clazz) {
        if (CollectionUtils.isEmpty(list)) {
            list = Collections.emptyList();
        }
        List<T> result = new ArrayList<>();
        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            Object object = iterator.next();
            try {
                T t = clazz.newInstance();
                BeanUtils.copyProperties(object, t);
                result.add(t);
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.error("Object copy exception {}", ex.getMessage());
                return error();
            }
        }
        return success(result);
    }

    public static Result success() {
        return new Result();
    }

    public static Result successPage(List docs, long count) {
        return new Result(docs, count);
    }

    public static Result successPage(List docs) {
        return successPage(docs, Long.parseLong(docs.size() + ""));
    }

    public static <T> Result successPage(List docs, Class<T> clazz) {
        return successPage(docs, clazz, Long.parseLong(docs.size() + ""));
    }

    public static <T> Result successPage(List docs, Class<T> clazz, long count) {
        if (CollectionUtils.isEmpty(docs)) {
            docs = Lists.newArrayList();
        }
        List<T> list = Lists.newArrayList();
        T       t;
        for (Object o : docs) {
            try {
                t = clazz.newInstance();
                BeanUtils.copyProperties(o, t);
                list.add(t);
            } catch (Exception e) {
                e.printStackTrace();
                return error();
            }
        }
        return successPage(list, count);
    }

    public static Result error(Integer status, String message) {
        return new Result(status, message);
    }

    public static Result error(ResultEnum resultEnum) {
        return new Result(resultEnum);
    }

    public static Result error(String message) {
        return new Result(ResultEnum.REQUEST_OPERATION_ERROR.getStatus(), message);
    }

    public static Result error() {
        return new Result(ResultEnum.REQUEST_OPERATION_ERROR);
    }
}
