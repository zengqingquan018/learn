package com.example.demo.controller;

import com.example.demo.common.ResponseResult;
import com.example.demo.po.User;
import com.example.demo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private UserService userService;

    @GetMapping("/getById.do")
    public ResponseResult<User> getById(@RequestParam("id") Long id) {
        return ResponseResult.success(userService.getById(id));
    }

    @GetMapping("/getByList.do")
    public ResponseResult<List<User>> getByList() {
        return ResponseResult.success(userService.getByList());
    }

    @GetMapping("/add.do")
    public ResponseResult add() {
        userService.add();
        return ResponseResult.success(null);
    }

    @GetMapping("/batchAdd.do")
    public ResponseResult batchAdd() {
        userService.batchAdd();
        return ResponseResult.success(null);
    }
    @GetMapping("/insertOne.do")
    public ResponseResult insertOne() {
        userService.insertOne();
        return ResponseResult.success(null);
    }
}
