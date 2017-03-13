package org.lwerl.caloriesmng.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static final DateTimeFormatter DATE_TME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static String toString(LocalDateTime ldt) {
        return toString(ldt, DATE_TME_FORMATTER);
    }

    public static String toString(LocalDateTime ldt, DateTimeFormatter formatter) {
        return ldt == null ? "" : ldt.format(formatter);
    }

    public static LocalDateTime toDateTime(String str) {
        return toDateTime(str, DATE_TME_FORMATTER);
    }

    public static LocalDateTime toDateTime(String str, DateTimeFormatter formatter) {
        return StringUtils.isEmpty(str) ? LocalDateTime.now() : LocalDateTime.parse(str, formatter);
    }

    public static LocalDate toDate(String str, LocalDate def) {
        return StringUtils.isEmpty(str) ? def : LocalDate.parse(str, DATE_FORMATTER);
    }

    public static LocalTime toTime(String str, LocalTime def) {
        return StringUtils.isEmpty(str) ? def : LocalTime.parse(str, TIME_FORMATTER);
    }

    public static LocalDateTime startDateTime(String str) {
        return LocalDateTime.of(toDate(str, LocalDate.of(0, 1, 1)), LocalTime.MIN);
    }

    public static LocalDateTime endDateTime(String str) {
        return LocalDateTime.of(toDate(str, LocalDate.of(3000, 1, 1)), LocalTime.MAX);
    }

    public static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <= 0;
    }
}