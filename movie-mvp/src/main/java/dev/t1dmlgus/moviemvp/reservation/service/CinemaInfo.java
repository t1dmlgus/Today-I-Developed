package dev.t1dmlgus.moviemvp.reservation.service;

import dev.t1dmlgus.moviemvp.reservation.domain.Movie;
import dev.t1dmlgus.moviemvp.reservation.domain.Theater;
import dev.t1dmlgus.moviemvp.reservation.util.DateUtil;
import lombok.Getter;

import java.util.List;

@Getter
public class CinemaInfo<T> {

    private final String cinemaName;
    private final List<T> listOfCinema;

    public CinemaInfo(String cinemaName, List<T> screenList) {
        this.cinemaName = cinemaName;
        listOfCinema = screenList;
    }

    public String cinemaResponse(){

        StringBuilder sb = new StringBuilder();
        int index = 0;

        if (listOfCinema.get(0).getClass().equals(Theater.class)) {
            for (T t : listOfCinema) {
                index++;
                Theater t1 = (Theater) t;
                sb.append(t1.getTheaterName());
                if (index < listOfCinema.size())
                    sb.append(", ");
            }
            return "영화관(" + cinemaName + ") 및 상영관[" + sb + "]이 등록되었습니다.";
        }
        if (listOfCinema.get(0).getClass().equals(Movie.class)) {
            for (T t : listOfCinema) {
                index++;
                Movie t1 = (Movie) t;
                sb.append(t1.getTitle());
                if (index < listOfCinema.size())
                    sb.append(", ");
            }
            return DateUtil.localDateTimeToday() + " 영화관(" + cinemaName + ")에 영화[" + sb + "] 상영리스트가 초기화 되었습니다.";
        }

        return null;
    }
}
