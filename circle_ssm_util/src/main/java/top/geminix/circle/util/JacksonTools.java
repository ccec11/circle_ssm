package top.geminix.circle.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @version 1.0.0
 * @Author Zachary
 * @createTime 2020年12月14日 09:28:00
 */
public class JacksonTools {
    public static String createJsonString(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = null;
        try {
            jsonStr = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    public static <T> T getObject(String jsonString, Class<T> type) {
        ObjectMapper mapper = new ObjectMapper();
        T t = null;
        try {
            mapper.readValue(jsonString, (Class<T>) t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }
}