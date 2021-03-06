package dev.t1dmlgus.moviemvp.reservation.domain;

import dev.t1dmlgus.moviemvp.reservation.util.DateUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@NoArgsConstructor
@ToString(exclude = {"theaters", "screens"})
@Getter
@Entity
@Table(name = "cinemas")
public class Cinema {       // 영화관

    public static HashMap<String, Cinema> cinemaInstances = new HashMap<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long cinemaId;
    public String cinemaName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cinema")
    private List<Theater> theaters = new ArrayList<>();

    @OneToMany
    private List<Screen> screens = new ArrayList<>();


    @Builder
    private Cinema(String cinemaName, List<Theater> theaters) {
        this.cinemaName = cinemaName;
        this.theaters = theaters;
    }


    public static Cinema newInstance(String cinemaName, List<Theater> theaters) {
        Cinema cinema = Cinema.builder()
                .cinemaName(cinemaName)
                .theaters(theaters)
                .build();

        cinemaInstances.put(cinemaName, cinema);
        cinema.addTheaterToCinema(theaters);
        return cinema;
    }

    // 연관관계
    private void addTheaterToCinema(List<Theater> theaters) {
        for (Theater theater : theaters) {
            theater.setCinema(this);
        }
    }



//    public static Theater getInstance(TheaterPlace theaterPlace) {
//        // 해당 영화관이 존재할 경우 가져오고, 아니면 만듬
//
//        Theater theater = theaterInstance.get(theaterPlace.getPlace());
//        if (Objects.isNull(theater)) {
//            theater = new Theater(theaterPlace);
//            theaterInstance.put(theaterPlace.getPlace(), theater);
//            return theater;
//        }
//        return theater;
//    }



    public List<Movie> getShowingMovieFromMovie(){
        return Movie.showingMovie;
    }


    // 오늘의 상영리스트를 만들어라(영화관 별)
    public List<Screen> todayScreenInit(ScreenSchedule screenSchedule) {

        // 상영리스트 초기화
        screens.clear();

        // 상영영화 가져오기
        List<Movie> showingMovie = this.getShowingMovieFromMovie();

        // 상영날짜
        String date = screenSchedule.getDate();

        // 상영영화
        for (ScreenSchedule.ScreenOnMovie screenOnMovie : screenSchedule.getScreenOnMovies()) {
            Movie movie = showingMovie.stream()
                    .filter(i -> i.getTitle().equals(screenOnMovie.getMovieTitle()))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

            // 상영관
            for (ScreenSchedule.TheaterOfScreenMovie theaterDetail : screenOnMovie.getTheaterOfScreenMovies()) {
                Theater theater = this.getTheaters().stream()
                        .filter(i -> i.getTheaterName().equals(theaterDetail.getTheaterName()))
                        .findFirst()
                        .orElseThrow(RuntimeException::new);

                //상영 시간
                LocalDateTime startTime = DateUtil.toLocalDateTime(date, theaterDetail.getStartTime());
                screens.add(Screen.newInstance(movie, theater, startTime));
            }
        }
        // 연관관계 추가(상영시간표)
        this.getScreens().addAll(screens);
        return screens;
    }
}
