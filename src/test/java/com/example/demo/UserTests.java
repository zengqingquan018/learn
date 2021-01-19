package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.po.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/30 17:15
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void add() {
        User user = new User();
        user.setChineseName("测试");
        user.setUserName("test");
        user.setPassword("214dfrr");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertSelective(user);
    }

    @Test
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
        userMapper.batchInsert2(userList);
        userMapper.batchInsert(userList);
    }

    @Test
    public void insertOne() {
        User user = new User();
        user.setChineseName("测试");
        user.setUserName("test");
        user.setPassword("214dfrr");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insertOne(user, "测试1");
    }

    @Test
    public void select() {
        userMapper.selectAll();
        User user = userMapper.selectByPrimaryKey(1L);
    }



}
