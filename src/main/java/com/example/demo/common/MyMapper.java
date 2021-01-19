package com.example.demo.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2021/1/4 20:06
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
