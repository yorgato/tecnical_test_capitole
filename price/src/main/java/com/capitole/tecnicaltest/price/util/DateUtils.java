package com.capitole.tecnicaltest.price.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    static final String DATE_PATTERN = "yyyy-MM-dd HH.mm.ss";

    public static LocalDateTime parseToLocalDateTime(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static String parseToString(LocalDateTime date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
            return formatter.format(date);
        } catch (DateTimeParseException e) {
            return null;
        }
    }
}
