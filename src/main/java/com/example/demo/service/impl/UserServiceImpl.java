package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.po.User;
import com.example.demo.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/28 11:07
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getByList() {
        log.info("=====================");
        return userMapper.selectAll();
    }

    @Override
    public User getById(Long id) {
        return userMapper.getById(id);
    }

    @Override
    public void add() {
        User user = new User();
        user.setChineseName("测试");
        user.setUserName("test");
        user.setPassword("214dfrr");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertSelective(user);
    }

    @Override
    public void batchAdd() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setChineseName("测试");
        user.setUserName("test");
        user.setPassword("214dfrr");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        User user1 = new User();
        user1.setChineseName("测试");
        user1.setUserName("test");
        user1.setPassword("214dfrr");
        user1.setCreateTime(new Date());
        user1.setUpdateTime(new Date());
        userList.add(user);
        userList.add(user1);
        userMapper.batchInsert(userList);
    }

    @Override
    public void insertOne() {
        User user = new User();
        user.setChineseName("测试");
        user.setUserName("test");
        user.setPassword("214dfrr");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertOne(user,"测试1");
    }


}
