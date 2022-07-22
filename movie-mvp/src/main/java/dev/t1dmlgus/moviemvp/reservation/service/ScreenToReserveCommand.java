package dev.t1dmlgus.moviemvp.reservation.service;


import dev.t1dmlgus.moviemvp.reservation.domain.Cinema;
import dev.t1dmlgus.moviemvp.reservation.domain.Screen;
import dev.t1dmlgus.moviemvp.reservation.util.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
public class ScreenToReserveCommand {

    private String cinemaName;
    private String movieTitle;
    private String date;
    private String time;

    public Screen getScreenFromCinema() {

        Cinema cinema = Cinema.cinemaInstances.get(getCinemaName());

        // 영화 찾기, 1) 영화로 선별, 2) 시간으로 선별
        return cinema.getScreens().stream()
                .filter(i -> i.getMovie().getTitle().equals(movieTitle))
                .filter(i -> i.getStartTime().equals(DateUtil.toLocalDateTime(date, time)))
                .findFirst()
                .orElseThrow(RuntimeException::new);
                // 해당 상영은 없습니다.(예외처리)
                // (추가적으로) 해당 상영은 예매할 수 없습니다.
    }
}
