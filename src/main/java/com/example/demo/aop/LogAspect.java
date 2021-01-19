package com.example.demo.aop;


import com.alibaba.fastjson.JSONObject;


import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author ZQQ
 * @Date 2020/3/26 16:52
 */
@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(LoggerFactory.class);


    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    private void logPoint() {
    }


    @Around("logPoint()")
    public Object OperationLog(ProceedingJoinPoint point) throws Throwable {
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                    .getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            JSONObject param = new JSONObject();
            Object[] args = point.getArgs();
            String[] argNames = ((MethodSignature) point.getSignature()).getParameterNames();
            for (int i = 0; i < argNames.length; i++) {
                if (args.length < i) {
                    break;
                }
                Object o = args[i];
                if (o instanceof MultipartFile) {
                    String fileName = ((MultipartFile) o)
                            .getOriginalFilename();
                    param.put(argNames[i], fileName);
                } else {
                    param.put(argNames[i], o);
                }
            }
            logger.info("业务开始,uri:{},requestParam:{}", request.getRequestURI(),
                    JSONObject.toJSONString(param));
        } catch (Exception e) {
            logger.warn("获取入参失败", e);
        }
        Object result;
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        }
        logger.info("业务结束,结果:{}", JSONObject.toJSONString(result));
        return result;
    }
}

