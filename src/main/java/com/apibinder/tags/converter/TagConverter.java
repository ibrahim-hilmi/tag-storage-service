package com.apibinder.tags.converter;

import java.util.HashMap;
import java.util.Map;

public class TagConverter {

    public static Map<String, Integer> convertTagCounts(Object[] objects) {
        Map<String, Integer> result = new HashMap<>();

        for (Object obj : objects) {
            Object[] arr = (Object[]) obj;
            String tagValue = (String) arr[0];
            int count = ((Number) arr[1]).intValue();
            result.put(tagValue, count);
        }

        return result;
    }
}
