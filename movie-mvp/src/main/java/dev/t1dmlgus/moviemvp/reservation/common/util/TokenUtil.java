package dev.t1dmlgus.moviemvp.reservation.common.util;

import dev.t1dmlgus.moviemvp.reservation.common.exception.BusinessException;
import dev.t1dmlgus.moviemvp.reservation.common.exception.ErrorType;
import dev.t1dmlgus.moviemvp.reservation.domain.Cinema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;


public class TokenUtil {

    public static String generateToken(String area) {

        String areaCode = AreaType.getAreaCode(area);// 1
        HashMap<String, Cinema> cinemaInstances = Cinema.cinemaInstances;

        long count = cinemaInstances.values().stream()
                .filter(i -> i.getCinemaToken().substring(0, 1).equals(areaCode))
                .count();

        return areaCode + String.format("%03d", count+1);
    }

    public static String generateTheaterToken(String cinemaToken, int index) {
        String theaterNum = String.format("%02d", index);
        return cinemaToken + theaterNum;
    }

    @Getter
    @RequiredArgsConstructor
    public static enum AreaType {

        SEOUL("1", "서울"),
        GYEONGGIDO_INCHEON("3", "경기/인천"),
        CHUNGCHEONG_DAEJEON("4", "충청/대전"),
        JEOLLA_GWANGJU("5", "전라/광주"),
        GYEONGBUK_DAEGU("6", "경북/대구"),
        GYEONGNAM_BUSAN_ULSAN("7", "경남/부산/울산"),
        GANGWON("8", "강원"),
        JEJU("9", "제주");

        private final String areaCode;
        private final String areaName;

        public static String getAreaCode(String areaName) {

            return Arrays.stream(AreaType.values())
                    .filter(i -> i.getAreaName().equals(areaName))
                    .map(AreaType::getAreaCode)
                    .findFirst()
                    .orElseThrow(()-> new BusinessException(ErrorType.AREA_INVALID_PARAMETER));
        }
    }

}
