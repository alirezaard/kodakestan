package com.kodakestan.kodak.configuration.utils;

import java.util.Map;

public class MessageUtils {
    public static String putParams(String message, Map<String, Object> params) {
        String result = message;
        for (Map.Entry<String, Object> paramEntry : params.entrySet()) {
            result = result.replace("{" + paramEntry.getKey() + "}", String.valueOf(paramEntry.getValue()));
        }
        return result;
    }
}
