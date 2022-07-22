package dev.t1dmlgus.moviemvp.reservation.util;

import java.time.LocalDateTime;

public class DateUtil {

    public static LocalDateTime toLocalDateTime(String date, String time) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6));
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(2));

        return LocalDateTime.of(year, month, day, hour, minute);
    }
}
