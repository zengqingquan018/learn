package com.example.demo.response;

import com.example.demo.mybatis.SensitiveField;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Data;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/30 17:05
 */
@Data
public class UserResponse {

    @ApiModelProperty(value = "主键", name = "id")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;

    /**
     * 中文名
     */
    @Column(name = "chinese_name")
    @ApiModelProperty(value = "中文名", name = "chineseName")
    private String chineseName;

}
