package com.luxixi.utils;

import lombok.Data;

import java.util.List;

//@ApiModel("分页信息")
@Data
public class Pager<T> {

//    @ApiModelProperty("总行数")
    private long count;

//    @ApiModelProperty("业务数据")
    private List<T> docs;

    public Pager() {
    }

    public Pager(long count, List<T> docs) {
        this.count = count;
        this.docs = docs;
    }
}
