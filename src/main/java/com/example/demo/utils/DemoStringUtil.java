package com.example.demo.utils;

import java.util.UUID;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/28 14:10
 */
public class DemoStringUtil {

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
