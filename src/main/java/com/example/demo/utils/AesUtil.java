package com.example.demo.utils;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AesUtil {

    private static final Logger logger = LoggerFactory.getLogger(AesUtil.class);

    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    private static final String ALGORITHM = "AES";



    /**
     * AES加密 ECB加密
     *
     * @param encryptStr 待加密的base 64 code
     * @param decryptKey 加密密钥
     * @return 加密后的string
     * @throws
     */
    public static String aesEncrypt(String encryptStr, String decryptKey) {
        return parseByte2HexStr(aesEncryptToBytes(encryptStr, decryptKey));
    }

    /**
     * AES解密 ECB解密
     *
     * @param encryptStr 待解密的base 64 code
     * @param decryptKey 解密密钥
     * @return 解密后的string
     * @throws Exception
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) {
        return aesDecryptByBytes(parseHexStr2Byte(encryptStr), decryptKey);
    }


    /**
     * AES加密 ECB
     *
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(encryptKey.getBytes(), ALGORITHM);
            Cipher ecipher = Cipher.getInstance(TRANSFORMATION);
            ecipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            return ecipher.doFinal(content.getBytes(DEFAULT_CHARSET));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 解密
     *
     * @param encryptBytes 待解密的byte[]
     * @param decryptKey decryptKey
     * @return Base64后的数据
     */
    private static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(decryptKey.getBytes(), ALGORITHM);
            Cipher dcipher = Cipher.getInstance(TRANSFORMATION);
            dcipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            return new String(dcipher.doFinal((encryptBytes)), DEFAULT_CHARSET);
        } catch (Exception e) {
            logger.warn("解密失败:{}", e.getMessage());
            return null;
        }
    }


    /**
     * 将16进制转换成2进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        } else {
            byte[] result = new byte[hexStr.length() / 2];

            for (int i = 0; i < hexStr.length() / 2; ++i) {
                int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
                result[i] = (byte) (high * 16 + low);
            }
            return result;
        }
    }
    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    private static String parseByte2HexStr(byte[] buf) {
        if (null == buf) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; ++i) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
}