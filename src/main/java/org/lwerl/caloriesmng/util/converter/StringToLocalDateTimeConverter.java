package org.lwerl.caloriesmng.util.converter;

import org.lwerl.caloriesmng.util.TimeUtil;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

/**
 * GKislin
 * 15.04.2015.
 */
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String param) {
        return TimeUtil.toDateTime(param);
    }
}
