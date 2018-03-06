package com.middleware.cache.redis;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.middleware.cache.core.CacheException;
import com.middleware.cache.core.CacheHandler;

/**
 * @author Fe 2017-08-11
 */
public class SerializeUtils {

    public static byte[] serializeValue(Object object) {
        if (object == null) {
            return CacheHandler.NULL;
        } else {
            return JSON.toJSONBytes(object, SerializerFeature.UseSingleQuotes);
        }
    }

    public static byte[] serializeKey(String key) {
        return key.getBytes();
    }

    public static <T> T deserializeValue(byte[] bytes, Class<?> type) {
        if (bytes == null || Arrays.equals(CacheHandler.NULL, bytes)) {
            return null;
        } else {
            return JSON.parseObject(bytes, type);
        }
    }

    public static String deserializeKey(byte[] bytes) {
        if (bytes == null || bytes.length == 0) {
            return null;
        } else {
            return new String(bytes);
        }
    }

    public static byte[] serializeObject(Object object) {
        if (object == null) {
            return CacheHandler.NULL;
        }
        ObjectOutputStream objectOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new CacheException("实例化失败：" + object.getClass().getName() + "未实现java.io.Serializable", e);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Object deserializeObject(byte[] bytes) {
        if (bytes == null || Arrays.equals(CacheHandler.NULL, bytes)) {
            return null;
        }
        ByteArrayInputStream byteArrayOutputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(byteArrayOutputStream);
            return objectInputStream.readObject();
        } catch (Exception e) {
            throw new CacheException("实例化失败", e);
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
