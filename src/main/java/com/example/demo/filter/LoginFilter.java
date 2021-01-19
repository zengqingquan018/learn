package com.example.demo.filter;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.BaseConstants;
import com.example.demo.common.ResponseResult;
import com.example.demo.dto.UserDto;
import com.example.demo.enums.ResponseEnums;
import com.example.demo.po.User;
import com.example.demo.utils.UriUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2020/12/25 17:21
 */
@WebFilter(filterName = "loginFilter", urlPatterns = {"*.do"})
public class LoginFilter implements Filter {

    private final static String MEDIA_TYPE = "application/json;charset=UTF-8";

    private static final List<String> UN_FILETER_URI = new ArrayList<>();

    static {
        UN_FILETER_URI.add("/**/demo/**");
        UN_FILETER_URI.add("/**/user/**");
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (!UriUtils.isInclude(httpServletRequest.getRequestURI(), UN_FILETER_URI)) {
            HttpSession session = httpServletRequest.getSession();
            UserDto user = (UserDto) session.getAttribute(BaseConstants.USER);
            if (null == user) {
                ResponseResult responseResult = new ResponseResult(ResponseEnums.CODE_403);
                String resultJson = JSONObject.toJSONString(responseResult);
                JSONObject.parseObject(resultJson,ResponseResult.class);
                httpServletResponse.setContentType(MEDIA_TYPE);
                httpServletResponse.getWriter().write(resultJson);
                return;
            }
        }
        chain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
