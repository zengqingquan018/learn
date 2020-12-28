package com.example.demo.exception;

import com.example.demo.common.BaseConstants;
import com.example.demo.common.ResponseResult;
import com.example.demo.enums.ResponseEnums;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/28 10:11
 */
@Slf4j
@ControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseResult result(Exception e, HttpServletRequest request,
                                 HttpServletResponse response) {
        if (e instanceof BusinessException) {
            log.info("自定义异常", e);
            return new ResponseResult<>(((BusinessException) e).getCode(), e.getMessage(), null);
        } else {
            log.info("其他异常", e);
            return new ResponseResult<>(ResponseEnums.CODE_99999, null);
        }
    }
}
