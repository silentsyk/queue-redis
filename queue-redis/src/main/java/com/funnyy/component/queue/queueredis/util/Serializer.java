package com.funnyy.component.queue.queueredis.util;

/**
 * Created by sky on 17-5-18.
 */
public interface Serializer {
    String serialize(Object var1);

    <T> T deserialize(String var1, Class<T> var2);

    String addObjToJson(String var1, String var2, Object var3);
}
