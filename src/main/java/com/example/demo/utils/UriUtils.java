package com.example.demo.utils;

import java.util.List;
import org.springframework.util.AntPathMatcher;

/**
 * @Author ZQQ
 * @Date 2020/1/5 9:59
 */
public class UriUtils {

    /**
     * 判断url是否包含在某个数组中
     *
     * @param uri
     * @param uris
     * @return java.lang.Boolean
     * @author ZQQ
     * @date 2020/1/5
     */
    public static boolean isInclude(String uri, List<String> uris) {
        if (null == uris) {
            return false;
        }
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        return uris.stream().anyMatch(s -> antPathMatcher.match(s, uri));
    }
}
