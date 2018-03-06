package com.middleware.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 对密码进行加密和验证的类
 */
public final class CipherUtil {
    private static final String ALGORITHM_md5 = "MD5";
    private static Logger logger = LoggerFactory.getLogger(CipherUtil.class);

    private CipherUtil() {
    }

    /**
     * <p>
     * 验证加密数据和数据是否匹配。
     * </p>
     *
     * @param encoded 加密后的数据
     * @param data    需要鉴别的数据
     * @return true|false
     */
    public static boolean validate(String encoded, String data) {
        if (encoded.equalsIgnoreCase(encode(data))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * <p>
     * 加密数据，返回大写字母。
     * </p>
     * @param data 需要加密的数据
     * @return 加密后的数据
     */
    public static String encode(String data) {
        if (StringUtils.isNotEmpty(data)) {
            try {
                MessageDigest md = MessageDigest.getInstance(ALGORITHM_md5);
                md.reset();
                byte[] results = md.digest(data.getBytes("UTF-16LE"));
                StringBuffer buf = new StringBuffer();
                for (int i = 0; i < results.length; i++) {
                    if ((results[i] & 0xff) < 0x10) {
                        buf.append("0");
                    }
                    buf.append(Long.toString(results[i] & 0xff, 16));
                }
                return buf.toString().toUpperCase();
            } catch (NoSuchAlgorithmException | IOException e) {
                logger.error("CipherUtil encode Exception " + data, e);
                throw new RuntimeException("加密数据错误", e);
            }
        } else {
            return data;
        }
    }

    public static String encode(String algorithm, String data) {
        if (StringUtils.isNotEmpty(data)) {
            try {
                if (StringUtils.isEmpty(algorithm)) {
                    algorithm = ALGORITHM_md5;
                }
                MessageDigest digest = MessageDigest.getInstance(algorithm);
                digest.update(data.getBytes());
                byte[] messageDigest = digest.digest();
                // Create Hex String
                StringBuffer hexString = new StringBuffer();
                // 字节数组转换为 十六进制 数
                for (int i = 0; i < messageDigest.length; i++) {
                    String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                    if (shaHex.length() < 2) {
                        hexString.append(0);
                    }
                    hexString.append(shaHex);
                }
                return hexString.toString();
            } catch (Exception e) {
                logger.error("CipherUtil encode Exception " + data, e);
            }
        }
        return data.toUpperCase();
    }
}
