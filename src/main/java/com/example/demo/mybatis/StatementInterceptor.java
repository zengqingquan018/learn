package com.example.demo.mybatis;

import java.beans.Statement;
import java.sql.Connection;
import java.util.Properties;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.stereotype.Component;

/**
 * 描述：
 *
 * @author zengqingquan
 * @date 2021/1/4 18:54
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,
                Integer.class})
})
@Component
public class StatementInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        invocation.getTarget();
        return invocation.proceed();
//2
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
        // 4
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
