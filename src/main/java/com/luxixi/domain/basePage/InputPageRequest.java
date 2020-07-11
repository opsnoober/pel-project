package com.luxixi.domain.basePage;

import java.io.Serializable;

public class InputPageRequest implements Serializable {

    private Integer pageNum = 1;

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
