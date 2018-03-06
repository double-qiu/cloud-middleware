package com.middleware.common.util.http;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Jason
 */
public class HttpEntity {
    // 传入参数特定类型
    public static final String ENTITY_STRING = "$ENTITY_STRING$";
    public static final String ENTITY_FILE = "$ENTITY_FILEE$";
    public static final String ENTITY_BYTES = "$ENTITY_BYTES$";
    public static final String ENTITY_INPUTSTREAM = "$ENTITY_INPUTSTREAM$";
    public static final String ENTITY_SERIALIZABLE = "$ENTITY_SERIALIZABLE$";
    private static final List<String> SPECIAL_ENTITIY = Arrays.asList(ENTITY_STRING, ENTITY_BYTES, ENTITY_FILE,
            ENTITY_INPUTSTREAM, ENTITY_SERIALIZABLE);

    /**
     * 检测url是否含有参数，如果有，则把参数加到参数列表中
     *
     * @param url  资源地址
     * @param nvps 参数列表
     * @return 返回去掉参数的url
     */
    public static Map<String, Object> getUrlEntity(String url, List<NameValuePair> nvps, String encoding)
            throws UnsupportedEncodingException {
        if (url.contains("?") && url.indexOf("?") < url.indexOf("=")) {
            return buildParas(url.substring(url.indexOf("?") + 1));
        }
        return null;
    }

    /**
     * 参数转换，将map中的参数，转到参数列表中
     *
     * @param nvps 参数列表
     * @param map  参数列表（map）
     */
    public static org.apache.http.HttpEntity map2List(List<NameValuePair> nvps, Map<String, Object> map,
                                                      String encoding)
            throws UnsupportedEncodingException {
        org.apache.http.HttpEntity entity = null;
        if (map != null && map.size() > 0) {
            boolean isSpecial = false;
            // 拼接参数
            for (Entry<String, Object> entry : map.entrySet()) {
                if (SPECIAL_ENTITIY.contains(entry.getKey())) {
                    // 判断是否在之中
                    isSpecial = true;
                    if (ENTITY_STRING.equals(entry.getKey())) {
                        // string
                        entity = new StringEntity(String.valueOf(entry.getValue()), encoding);
                        break;
                    } else if (ENTITY_BYTES.equals(entry.getKey())) {
                        // file
                        entity = new ByteArrayEntity((byte[]) entry.getValue());
                        break;
                    } else if (ENTITY_FILE.equals(entry.getKey())) {
                        // file
                        break;
                    } else if (ENTITY_INPUTSTREAM.equals(entry.getKey())) {
                        // inputstream
                        break;
                    } else if (ENTITY_SERIALIZABLE.equals(entry.getKey())) {
                        // serializeable
                        break;
                    } else {
                        nvps.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
                    }
                } else {
                    nvps.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
                }
            }
            if (!isSpecial) {
                entity = new UrlEncodedFormEntity(nvps, encoding);
            }
        }
        return entity;
    }

    public static Map<String, Object> buildParas(String paras) {
        String[] p = paras.split("&");
        Map<String, Object> map = new HashMap<String, Object>();
        int pos = 0;
        for (int i = 0; i < p.length; i++) {
            pos = p[i].indexOf("=");
            map.put(p[i].substring(0, pos), p[i].substring(pos + 1));
            pos = 0;
        }
        return map;
    }
}
