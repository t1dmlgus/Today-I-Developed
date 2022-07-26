package dev.t1dmlgus.moviemvp.reservation.service;

import dev.t1dmlgus.moviemvp.reservation.common.util.DateUtil;
import dev.t1dmlgus.moviemvp.reservation.domain.Movie;
import dev.t1dmlgus.moviemvp.reservation.domain.Theater;
import lombok.Getter;

import java.util.List;

/**
 *
 * class : 영화관 응답 DTO
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        영화관 등록 & 상영리스트 등록 시
 *                                  데이터 타입을 제네릭으로 구현
 *                                  (상영관, 영화)
 *
 */
@Getter
public class CinemaInfo<T> {

    private final String cinemaName;
    private final List<T> listOfCinema;

    public CinemaInfo(String cinemaName, List<T> listOfCinema) {
        this.cinemaName = cinemaName;
        this.listOfCinema = listOfCinema;
    }

    public String cinemaResponse(){

        StringBuilder sb = new StringBuilder();
        int index = 0;

        if (listOfCinema.get(0).getClass().equals(Theater.class)) {
            for (T list : listOfCinema) {
                index++;
                Theater theater = (Theater) list;
                sb.append(theater.getTheaterName());
                if (index < listOfCinema.size())
                    sb.append(", ");
            }
            return "영화관(" + cinemaName + ") 및 상영관[" + sb + "]이 등록되었습니다.";
        }
        if (listOfCinema.get(0).getClass().equals(Movie.class)) {
            for (T list : listOfCinema) {
                index++;
                Movie movie = (Movie) list;
                sb.append(movie.getTitle());
                if (index < listOfCinema.size())
                    sb.append(", ");
            }
            return DateUtil.localDateTimeToday() + " 영화관(" + cinemaName + ")에 영화[" + sb + "] 상영리스트가 초기화 되었습니다.";
        }

        return null;
    }
}
