package com.middleware.common.util.http.serializer;


import java.io.IOException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.middleware.common.util.SerializeUtil;

public class JsonSerializer {
    private static final Logger log = LoggerFactory.getLogger(JsonSerializer.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.getSerializerProvider().setNullValueSerializer(
                new com.fasterxml.jackson.databind.JsonSerializer<Object>() {
                    public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider)
                            throws IOException, JsonProcessingException {
                        jgen.writeString("");

                    }
                });
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL);
        //下划线转驼峰。
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static <T> T deserialize(byte[] bytes, Class<T> clzss) throws SerializationException {
        if (SerializeUtil.isEmpty(bytes)) {
            return null;
        }
        try {
            return (T) mapper.readValue(bytes, 0, bytes.length, clzss);
        } catch (Exception ex) {
            throw new SerializationException("Could not read JSON: " + ex.getMessage(), ex);
        }
    }

    public static byte[] serialize(Object t) throws SerializationException {
        if (t == null) {
            return SerializeUtil.EMPTY_ARRAY;
        }
        try {
            return mapper.writeValueAsBytes(t);
        } catch (Exception ex) {
            throw new SerializationException("Could not write JSON: " + ex.getMessage(), ex);
        }
    }

    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonGenerationException e) {
            log.warn(e.getMessage());
        } catch (JsonMappingException e) {
            log.warn(e.getMessage());
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
        log.warn("toJson error...");
        return "";
    }

    /**
     * json字符串转换成java对象
     */
    public static <T> T toObject(String json, Class<T> clzss) {
        try {
            return mapper.readValue(json, clzss);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json字符串转换成java对象
     */
    public static <T> T toObject(String json, JavaType valueType) {
        try {
            return mapper.readValue(json, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取泛型的Collection Type
     *
     * @return JavaType Java类型
     * @since 1.0
     */

    public static JavaType getJavaType(Class<?> parametrized, Class<?> parameterClasses) {
        return mapper.getTypeFactory().constructParametrizedType(parametrized, parametrized, parameterClasses);
    }
}
