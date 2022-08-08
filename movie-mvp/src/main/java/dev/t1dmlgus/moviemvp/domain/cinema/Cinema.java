package dev.t1dmlgus.moviemvp.domain.cinema;

import dev.t1dmlgus.moviemvp.common.error.ErrorType;
import dev.t1dmlgus.moviemvp.common.error.exception.EntityNotFoundException;
import dev.t1dmlgus.moviemvp.common.error.exception.NotValidException;
import dev.t1dmlgus.moviemvp.common.util.DateUtil;
import dev.t1dmlgus.moviemvp.common.util.TokenUtil;
import dev.t1dmlgus.moviemvp.domain.AbstractEntity;
import dev.t1dmlgus.moviemvp.domain.movie.Movie;
import dev.t1dmlgus.moviemvp.domain.screen.Screen;
import dev.t1dmlgus.moviemvp.domain.screen.ScreenSchedule;
import dev.t1dmlgus.moviemvp.domain.theater.Theater;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * class : 영화관 Domain
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        도메인 별 연관관계(상영관, 상영시간표)
 * 2022-07-26           이의현        정적 팩토리메서드
 * 2022-07-26           이의현        상영시간표 비즈니스 로직 생성
 * 2022-07-26           이의현        상영되는 영화 조회
 * 2022-07-26           이의현        영화관 토큰 필드 추가
 *
 */

@ToString(exclude = {"theaters", "screens"})
@NoArgsConstructor
@Getter
@Table(name = "cinemas")
@Entity
public class Cinema extends AbstractEntity {

    // 영화관 싱글톤
    public static HashMap<String, Cinema> cinemaInstances = new HashMap<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cinemaId;

    private String cinemaToken;
    private String cinemaName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cinema")
    private List<Theater> theaters = new ArrayList<>();

    @OneToMany(mappedBy = "cinema")
    private List<Screen> screens = new ArrayList<>();

    @Builder
    private Cinema(String cinemaName, List<Theater> theaters, String area) {
        this.cinemaName = cinemaName;
        this.theaters = theaters;

        this.cinemaToken = TokenUtil.generateCinemaToken(area);
    }

    public static Cinema newInstance(String cinemaName, List<Theater> theaters, String area) {
        Cinema cinema = Cinema.builder()
                .cinemaName(cinemaName)
                .theaters(theaters)
                .area(area)
                .build();

        cinemaInstances.put(cinemaName, cinema);
        cinema.addTheaterToCinema(theaters);
        return cinema;
    }

    // 연관관계
    private void addTheaterToCinema(List<Theater> theaters) {
        int theaterNo = 1;
        for (Theater theater : theaters) {
            theater.setCinema(this, theaterNo);
            theaterNo++;
        }
    }


    public List<Movie> getShowingMovieFromMovie(){
        return Movie.showingMovie;
    }


    // 오늘의 상영리스트를 만들어라(영화관 별)
    public List<Screen> screenInit(ScreenSchedule screenSchedule) {

        // 지난 상영 시간표 clear
        clearBeforeScreenList();
        // 상영영화 가져오기
        List<Movie> showingMovie = getShowingMovieFromMovie();
        // 상영날짜
        String today = validScreenDate(screenSchedule);

        // 상영 시간표 초기화
        return todayScreenList(screenSchedule, showingMovie, today);
    }

    private List<Screen> todayScreenList(ScreenSchedule screenSchedule, List<Movie> showingMovie, String today) {
        for (ScreenSchedule.ScreenOnMovie screenOnMovie : screenSchedule.getScreenOnMovies()) {
            Movie movie = showingMovie.stream()
                    .filter(i -> i.getTitle().equals(screenOnMovie.getMovieTitle()))
                    .findFirst()
                    .orElseThrow(()-> new EntityNotFoundException(ErrorType.MOVIE_ENTITY_NOT_FOUND));

            // 상영관
            for (ScreenSchedule.TheaterOfScreenMovie theaterDetail : screenOnMovie.getTheaterOfScreenMovies()) {
                Theater theater = this.getTheaters().stream()
                        .filter(i -> i.getTheaterName().equals(theaterDetail.getTheaterName()))
                        .findFirst()
                        .orElseThrow(()->new EntityNotFoundException(ErrorType.THEATER_ENTITY_NOT_FOUND));

                //상영 시간
                LocalDateTime startTime = DateUtil.toLocalDateTime(today, theaterDetail.getStartTime());
//                screens.add(Screen.newInstance(movie, theater, startTime));
            }
        }
        // 연관관계 추가(상영시간표)
        this.getScreens().addAll(screens);
        return screens;
    }

    private String validScreenDate(ScreenSchedule screenSchedule) {
        String date = screenSchedule.getDate();
        if (!DateUtil.compareToday(date)) {
            throw new NotValidException(ErrorType.DATE_INVALID_PARAMETER);
        }
        return date;
    }

    private void clearBeforeScreenList() {
        screens.clear();
    }
}
