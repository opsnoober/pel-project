package com.luxixi.common.result;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luxixi.common.enums.ResultEnum;
import com.luxixi.utils.Pager;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * 统一返回
 * @author luxixi
 * @param <T>
 */
@Data
//@ApiModel(value = "全局统一返回数据结构")
public class Result<T> {

//    @ApiModelProperty(value = "返回码")
    private Integer status;

//    @ApiModelProperty(value = "提示信息")
    private String message;

//    @ApiModelProperty(value = "业务数据")
    private T result;

    public Result() {
        this.status = ResultEnum.REQUEST_SUCCESS.getStatus();
        this.message = ResultEnum.REQUEST_SUCCESS.getMessage();
    }

    public Result(ResultEnum resultEnum) {
        this.status = resultEnum.getStatus();
        this.message = resultEnum.getMessage();
    }

    public Result(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(Integer status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public Result(List<T> docs, Long count) {
        this.message = ResultEnum.REQUEST_SUCCESS.getMessage();
        this.status = ResultEnum.REQUEST_SUCCESS.getStatus();
        Pager<T> p = new Pager(count, docs);
        this.result = (T) p;
    }

    /**
     * 校验 Result 是否成功
     * @return
     */
    @JsonIgnore
    public boolean isSuccess() {
        return HttpStatus.OK.value() == this.status;
    }
}
