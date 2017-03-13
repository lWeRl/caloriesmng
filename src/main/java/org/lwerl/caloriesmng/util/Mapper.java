package org.lwerl.caloriesmng.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import java.time.LocalDateTime;

/**
 * Created by lWeRl on 06.03.2017.
 */
public class Mapper extends ObjectMapper {

    private static final ObjectMapper MAPPER = new Mapper();

    public static ObjectMapper getMapper() {
        return MAPPER;
    }

    private Mapper(){
        registerModule(new Hibernate5Module());

        SimpleModule customModule = new SimpleModule("customModule", new Version(1, 0, 0, null));
        customModule.addSerializer(new JsonLocalDateTimeConverter.UserSettingSerializer());
        customModule.addDeserializer(LocalDateTime.class, new JsonLocalDateTimeConverter.UserSettingDeserializer());
        registerModule(customModule);

        setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }
}
