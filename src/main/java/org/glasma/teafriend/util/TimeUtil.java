package org.glasma.teafriend.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static final DateTimeFormatter DATE_TME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TME_FORMATTER);
    }

    public static LocalDate parseLocalDate(String str, LocalDate def) {
        return StringUtils.isEmpty(str) ? def : LocalDate.parse(str);
    }

    public static LocalTime parseLocalTime(String str, LocalTime def) {
        return StringUtils.isEmpty(str) ? def : LocalTime.parse(str);
    }

    public static LocalDateTime parseLocalDateTime(String str) {
        return parseLocalDateTime(str, DATE_TME_FORMATTER);
    }

    public static LocalDateTime parseLocalDateTime(String str, DateTimeFormatter formatter) {
        return StringUtils.isEmpty(str) ? LocalDateTime.now() : LocalDateTime.parse(str, formatter);
    }
}
