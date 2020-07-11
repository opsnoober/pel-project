package com.luxixi.mapper;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 基础Mapper
 * @author xiaoyu
 * @param <T>
 */
@RegisterMapper
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
