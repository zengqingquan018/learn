package com.example.demo.mapper;

import com.example.demo.po.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {

    User getById(@Param("id") Long id);

    void batchInsert(@Param("userList") List<User> userList);

    void insertOne(@Param("user") User user, @Param("chineseName") String chinese);
}