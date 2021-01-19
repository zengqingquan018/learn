package com.example.demo.service;

import com.example.demo.po.User;
import com.example.demo.request.LoginRequest;
import com.example.demo.response.UserResponse;
import java.util.List;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/28 11:07
 */
public interface UserService {


    /**
     * 描述:批量查询
     *
     * @param
     * @return {@link List< UserResponse>}
     * @throws
     * @author zengqingquan
     * @date 2020/12/30 17:18
     */
    List<UserResponse> getByList();

    /**
     * 描述:查询一个详细信息
     *
     * @param id
     * @return {@link UserResponse}
     * @throws
     * @author zengqingquan
     * @date 2020/12/30 17:18
     */
    UserResponse getById(Long id);

    String login(LoginRequest loginRequest);
}
