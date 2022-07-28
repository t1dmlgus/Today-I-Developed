package dev.t1dmlgus.moviemvp.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * class : Date Util
 * version 1.0
 * ==========================================
 * DATE              DEVELOPER   NOTE
 * ==========================================
 * 2022-07-26        이의현        서비스 날짜 Util
 *
 *
 */
public class DateUtil {

    public static LocalDateTime toLocalDateTime(String date, String time) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6));
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(2));

        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public static String toLocalDateToString(LocalDateTime yearDateHourMinute){

        String year = String.valueOf(yearDateHourMinute.getYear());
        String month = String.valueOf(yearDateHourMinute.getMonth());
        String date = String.valueOf(yearDateHourMinute.getDayOfMonth());

        return "[" + year + "/" + month + "/" + date + "]";
    }

    public static String localDateTimeToday() {
        LocalDateTime now = LocalDateTime.now();

        String year = String.valueOf(now.getYear());
        String month = String.valueOf(now.getMonthValue());
        String date = String.valueOf(now.getDayOfMonth());

        return "[" + year + "/" + month + "/" + date + "]";
    }

    public static boolean compareToday(String date) {

        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6));

        LocalDate screenScheduleDate = LocalDate.of(year, month, day);
        return LocalDateTime.now().toLocalDate().isEqual(screenScheduleDate);
    }
}
