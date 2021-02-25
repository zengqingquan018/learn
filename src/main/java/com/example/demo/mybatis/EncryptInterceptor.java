package com.example.demo.mybatis;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * 描述：加密-目前只对入参是一个实体类的dao层有用。对入参有两个的，或入参为list的不支持
 *
 * @author zengqingquan
 * @date 2020/12/23 16:30
 */

@Slf4j
@Component
@Intercepts({
        @Signature(type = ParameterHandler.class, method = "setParameters", args = PreparedStatement.class),
})
public class EncryptInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //3
        ParameterHandler parameterHandler = (ParameterHandler) invocation.getTarget();
        // 获取参数对像，即 mapper 中 paramsType 的实例
        Field parameterField = parameterHandler.getClass().getDeclaredField("parameterObject");
        parameterField.setAccessible(true);
        //取出实例
        Object parameterObject = parameterField.get(parameterHandler);
        if (parameterObject != null) {
            if (parameterObject instanceof ParamMap) {
                // 多参数或者入参为list
                ParamMap paramMap = (ParamMap) parameterObject;
                // 包装成paramMap会多产生key为paramn，值为入参的对象，使用hashCode防止重复加密
                List<Integer> hashList = new ArrayList<>();
                paramMap.forEach((k, v) -> {
                    if (Objects.nonNull(v)) {
                        if (v instanceof List) {
                            // 多参数中一个入参为list。遍历list加密
                            if (!hashList.contains(v.hashCode())) {
                                ((List) v).forEach(this::setSensitiveData);
                                hashList.add(v.hashCode());
                            }
                        } else {
                            //多参数中参数不为list
                            if (!hashList.contains(v.hashCode())) {
                                setSensitiveData(v);
                                hashList.add(v.hashCode());
                            }
                        }
                    }
                });
            } else {
                setSensitiveData(parameterObject);
            }
        }
        return invocation.proceed();
    }

    private void setSensitiveData(Object parameterObject) {
        Class<?> parameterObjectClass = parameterObject.getClass();
        //校验该实例的类是否被@SensitiveData所注解
        SensitiveData sensitiveData = AnnotationUtils
                .findAnnotation(parameterObjectClass, SensitiveData.class);
        if (Objects.nonNull(sensitiveData)) {
            //取出当前当前类所有字段，传入加密方法
            Field[] declaredFields = parameterObjectClass.getDeclaredFields();
            try {
                MybatisEncrypt.encrypt(declaredFields, parameterObject);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
        //2
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
