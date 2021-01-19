package com.example.demo.controller;

import com.example.demo.common.ResponseResult;
import com.example.demo.request.LoginRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/28 10:52
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getById.do")
    @ApiOperation("查询用户详细信息")
    public ResponseResult<UserResponse> getById(@RequestParam("id") Long id) {
        return ResponseResult.success(userService.getById(id));
    }

    @ApiOperation("查询所有用户")
    @GetMapping("/getByList.do")
    public ResponseResult<List<UserResponse>> getByList() {
        return ResponseResult.success(userService.getByList());
    }

    @GetMapping("login.do")
    @ApiOperation("登录")
    public ResponseResult<String> login(@RequestBody LoginRequest loginRequest) {

        return ResponseResult.success(userService.login(loginRequest));
    }

    @GetMapping("test.do")
    public ResponseResult<Test> test() {
        Test test = new Test();
        test.setA(1);
        return ResponseResult.success(test);
    }

    public
    class Test {

        private Integer a;
        private BigDecimal b;

        public Integer getA() {
            return a;
        }

        public void setA(Integer a) {
            this.a = a;
        }

        public BigDecimal getB() {
            return b;
        }

        public void setB(BigDecimal b) {
            this.b = b;
        }
    }
}
