package com.example.demo.service;

import com.example.demo.po.User;
import java.util.List;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/28 11:07
 */
public interface UserService {


    List<User> getByList();

    User getById(Long id);

    void add();

    void batchAdd();

    void insertOne();
}
