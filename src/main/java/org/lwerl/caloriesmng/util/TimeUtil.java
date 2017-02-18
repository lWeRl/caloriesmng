package org.lwerl.caloriesmng.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String toString(LocalDateTime date) {
        return date == null ? "null" : date.format(DATE_TIME_FORMATTER);
    }
}