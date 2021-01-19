package com.example.demo.mybatis;

import com.example.demo.utils.AesUtil;
import java.lang.reflect.Field;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 描述：加密
 *
 * @author zengqingquan
 * @date 2020/12/23 15:44
 */
@Slf4j
public class MybatisEncrypt {

    private final static String MYBATIS_ENCRYPT_KEY = "MyEncryptKey!A#C";


    /**
     * 描述:加密
     *
     * @param declaredFields
     * @param paramsObject
     * @return {@link T}
     * @throws
     * @author zengqingquan
     * @date 2020/12/23 16:34
     */
    public static <T> T encrypt(Field[] declaredFields, T paramsObject)
            throws IllegalAccessException {
        for (Field field : declaredFields) {
            //取出所有被EncryptDecryptField注解的字段
            SensitiveField sensitiveField = field.getAnnotation(SensitiveField.class);
            if (!Objects.isNull(sensitiveField)) {
                field.setAccessible(true);
                Object object = field.get(paramsObject);
                //暂时只实现String类型的加密
                if (object instanceof String) {
                    String value = (String) object;
                    if (StringUtils.isNotEmpty(value)) {
                        field.set(paramsObject, AesUtil.aesEncrypt(value, MYBATIS_ENCRYPT_KEY));
                    }
                }
            }
        }
        return paramsObject;
    }


    public static <T> T decrypt(T result) throws IllegalAccessException {
        //取出resultType的类
        Class<?> resultClass = result.getClass();
        Field[] declaredFields = resultClass.getDeclaredFields();
        for (Field field : declaredFields) {
            //取出所有被EncryptDecryptField注解的字段
            SensitiveField sensitiveField = field.getAnnotation(SensitiveField.class);
            if (!Objects.isNull(sensitiveField)) {
                field.setAccessible(true);
                Object object = field.get(result);
                //只支持String的解密
                if (object instanceof String) {
                    String value = (String) object;
                    if (StringUtils.isNotEmpty(value)) {
                        //对注解的字段进行逐一解密 为空或者未加密的字段，直接默认为数据库原字段
                        try {
                            String newValue = AesUtil.aesDecrypt(value, MYBATIS_ENCRYPT_KEY);
                            if (StringUtils.isNotEmpty(newValue)) {
                                field.set(result, newValue);
                            }
                        } catch (Exception e) {
                            log.warn("数据库AES解密失败,失败字段值:{}", value);
                            // ignore
                        }
                    }
                }
            }
        }
        return result;
    }

}
