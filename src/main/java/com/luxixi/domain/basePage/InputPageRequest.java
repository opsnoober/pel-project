package com.luxixi.domain.basePage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(value = "分页")
public class InputPageRequest implements Serializable {

    @ApiModelProperty(value = "页数")
    private Integer pageNum = 1;

    @ApiModelProperty(value = "页码")
    private Integer pageSize = 10;

    public Integer getPageNum() {
        return (pageNum == null || pageNum < 0 ) ? 1 : pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return (pageSize == null || pageSize < 0 ) ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
