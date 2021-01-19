package com.example.demo.request;

import lombok.Data;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/30 17:13
 */
@Data
public class PageRequest {


    private Integer pageNum = 1;

    private Integer pageSize = 15;
}
