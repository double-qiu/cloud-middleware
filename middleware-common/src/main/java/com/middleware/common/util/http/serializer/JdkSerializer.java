package com.middleware.common.util.http.serializer;


import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;

import com.middleware.common.util.SerializeUtil;

/**
 * 使用Jdk自带的序列方式来实现，用spring的扩展。
 *
 * @author Jason
 */
public class JdkSerializer {

    private static final Converter<Object, byte[]> serializer = new SerializingConverter();
    private static final Converter<byte[], Object> deserializer = new DeserializingConverter();

    public static Object deserialize(byte[] bytes) throws SerializationException {
        if (SerializeUtil.isEmpty(bytes)) {
            return null;
        }
        try {
            return deserializer.convert(bytes);
        } catch (Exception ex) {
            throw new SerializationException("Cannot deserialize", ex);
        }
    }

    public static byte[] serialize(Object object) throws SerializationException {
        if (object == null) {
            return SerializeUtil.EMPTY_ARRAY;
        }
        try {
            return serializer.convert(object);
        } catch (Exception ex) {
            throw new SerializationException("Cannot serialize", ex);
        }
    }
}
