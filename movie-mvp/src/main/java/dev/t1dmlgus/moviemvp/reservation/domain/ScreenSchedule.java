package dev.t1dmlgus.moviemvp.reservation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@ToString
@Getter
public class ScreenSchedule {

    private String date;
    private String cinemaName;
    private List<ScreenOnMovie> screenOnMovies;


    @ToString
    @NoArgsConstructor
    @Getter
    public static class ScreenOnMovie {

        private String movieTitle;
        private List<TheaterOfScreenMovie> theaterOfScreenMovies;

    }

    @ToString
    @NoArgsConstructor
    @Getter
    public static class TheaterOfScreenMovie {

        private String theaterName;
        private String startTime;
    }



//    public List<Screen> toTodayScreenListEntity() {
//
//        ArrayList<Screen> screenList = new ArrayList<>();
//
//        // 영화관 가져오기
//        Cinema cinema = Cinema.cinemaInstances.get(cinemaName);
//
//        for (ScreenOnMovie screenOnMovie : screenOnMovies) {
//            Movie movie = cinema.getShowingMovieFromMovie().stream()
//                    .filter(i -> i.getTitle().equals(screenOnMovie.getMovieTitle()))
//                    .findFirst()
//                    .orElseThrow(RuntimeException::new);
//                    // 상영중인 영화가 없습니다.(예외처리)
//
//            for (TheaterOfScreenMovie theaterofScreenMovie : screenOnMovie.getTheaterOfScreenMovies()) {
//
//                Theater theater = cinema.getTheaters().stream()
//                        .filter(i -> i.getTheaterName().equals(theaterofScreenMovie.getTheaterName()))
//                        .findFirst()
//                        .orElseThrow(RuntimeException::new);
//                        // 상영관이 없습니다.(예외처리)
//
//                LocalDateTime startTime = DateUtil.toLocalDateTime(date, theaterofScreenMovie.startTime);
//                screenList.add(Screen.newInstance(movie, theater, startTime));
//            }
//        }
//        return screenList;
//    }
}
