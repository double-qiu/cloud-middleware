package com.middleware.common.util.http.serializer;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.middleware.common.util.SerializeUtil;

/**
 * @author Jason
 */
public class KryoSerializer {

    private static final Kryo kryo = new Kryo();

    public static byte[] serializeByKryo(Object object) throws SerializationException {
        Output output = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            output = new Output(bos, SerializeUtil.BUFFER_SIZE);
            kryo.writeObject(output, object);
            byte[] b = output.toBytes();
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
        return null;
    }

    public static Object unserializeByKryo(byte[] b) throws SerializationException {
        Input input = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(b);
            input = new Input(bis, SerializeUtil.BUFFER_SIZE);
            return kryo.readClassAndObject(input);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return null;
    }
}
