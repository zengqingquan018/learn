package com.example.demo.po;

import com.example.demo.mybatis.SensitiveData;
import com.example.demo.mybatis.SensitiveField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@ApiModel(value = "User")
@Data
@Table(name = "user")
@SensitiveData
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "主键", name = "id")
    @Id
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;

    /**
     * 中文名
     */
    @Column(name = "chinese_name")
    @ApiModelProperty(value = "中文名", name = "chineseName")
    private String chineseName;

    /**
     * 密码
     */
    @SensitiveField
    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @ApiModelProperty(value = "更新时间", name = "updateTime")
    private Date updateTime;
}