package com.example.demo.service.impl;

import com.example.demo.common.BaseConstants;
import com.example.demo.dto.UserDto;
import com.example.demo.enums.ResponseEnums;
import com.example.demo.exception.BusinessException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.po.User;
import com.example.demo.request.LoginRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
    @Autowired
    private HttpServletRequest request;

    @Override
    public List<UserResponse> getByList() {
        List<User> userList = userMapper.selectAll();
        List<UserResponse> userResponses = new ArrayList<>();
        userList.forEach(p -> {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(p, UserResponse.class);
            userResponses.add(userResponse);
        });
        return userResponses;
    }

    @Override
    public UserResponse getById(Long id) {

        User user = userMapper.getById(id);
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public String login(LoginRequest loginRequest) {
        if (loginRequest.isWrong()) {
            throw new BusinessException("用户名或密码不能为空");
        }
        User user = new User();
        user.setUserName(loginRequest.getUserName());
        user = userMapper.selectOne(user);
        if (null == user) {
            throw new BusinessException("用户名错误");
        }
        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new BusinessException("密码错误");
        }
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        request.getSession().setAttribute(BaseConstants.USER, userDto);
        return "";
    }


}
