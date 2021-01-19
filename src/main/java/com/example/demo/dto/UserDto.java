package com.example.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import lombok.Data;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/31 14:53
 */
@Data
public class UserDto {
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 中文名
     */
    @Column(name = "chinese_name")
    private String chineseName;


}
