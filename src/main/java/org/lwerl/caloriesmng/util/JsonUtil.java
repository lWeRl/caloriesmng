package org.lwerl.caloriesmng.util;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;

/**
 * Created by lWeRl on 06.03.2017.
 */
public class JsonUtil {
    private static final Mapper mapper = new Mapper();

    public static <T> MappingIterator<T> readValues(String json, Class<T> clazz) throws IOException {
        ObjectReader reader = mapper.readerFor(clazz);
        return reader.readValue(json);
    }

    public static <T> T readValue(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }

    public static <T> String writeValue(T obj) throws IOException {
        return mapper.writeValueAsString(obj);
    }
}