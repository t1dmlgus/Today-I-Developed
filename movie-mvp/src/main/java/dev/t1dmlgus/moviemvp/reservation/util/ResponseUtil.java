package dev.t1dmlgus.moviemvp.reservation.util;

public class ResponseUtil {

    public static String initScreenUtil(String date, String cinemaName){
        return "[" + date + "] " + "영화관(" + cinemaName + ")에 상영리스트가 초기화되었습니다.";
    }
}
