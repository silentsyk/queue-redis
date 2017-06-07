package com.funnyy.component.queue.queueredis.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Created by sky on 17-5-18.
 */
public class JacksonSerializer implements Serializer {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public JacksonSerializer() {
    }

    public String serialize(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException var3) {
            throw new RuntimeException(var3);
        }
    }

    public <T> T deserialize(String rawStr, Class<T> klass) {
        if(null != rawStr && rawStr.length() != 0) {
            try {
                Object e = objectMapper.readValue(rawStr, klass);
                return (T)e;
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }
        } else {
            return null;
        }
    }

    public String addObjToJson(String json, String key, Object obj) {
        try {
            ObjectNode e = objectMapper.createObjectNode();
            JsonNode rootNode = objectMapper.readTree(json);
            e.setAll((ObjectNode)rootNode);
            e.putPOJO(key, obj);
            return objectMapper.writeValueAsString(e);
        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }
    }

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}