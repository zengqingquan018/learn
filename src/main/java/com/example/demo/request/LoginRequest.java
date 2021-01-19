package com.example.demo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/31 14:26
 */
@Data
@ApiModel("登录请求类")
public class LoginRequest {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    public boolean isWrong() {
        if (StringUtils.isEmpty(this.userName) || StringUtils.isEmpty(this.password)) {
            return true;
        }
        return false;
    }
}
