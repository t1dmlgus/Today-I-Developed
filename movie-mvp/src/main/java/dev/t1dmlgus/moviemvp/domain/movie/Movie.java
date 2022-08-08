package dev.t1dmlgus.moviemvp.domain.movie;

import dev.t1dmlgus.moviemvp.common.error.ErrorType;
import dev.t1dmlgus.moviemvp.common.error.exception.EntityNotFoundException;
import dev.t1dmlgus.moviemvp.common.util.TokenUtil;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * class : 영화 Domain
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        정적 팩토리 메서드 구현
 * 2022-07-26           이의현        영화상태 변경 비즈니스 로직
 * 2022-07-26           이의현        상영중인 영화 리스트 추가
 * 2022-07-27           이의현        영화 토큰 필드 추가
 *
 */

@ToString
@NoArgsConstructor(force = true)
@Getter
@Entity
@Table(name = "movies")
public class Movie {

    public static List<Movie> showingMovie = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private final String movieToken;
    private final String title;
    private final String runningTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    private Movie(String title, String runningTime) {
        this.title = title;
        this.runningTime = runningTime;
        this.status = Status.BEFORE_SCREENING;
        this.movieToken = TokenUtil.generateMovieToken();
    }

    public static Movie newInstance(String title, String runningTime) {
        return Movie.builder()
                .title(title)
                .runningTime(runningTime)
                .build();
    }

    @Getter
    @RequiredArgsConstructor
    public enum Status {

        SHOWING("상영중"),
        BEFORE_SCREENING("상영전"),
        END_OF_SCREENING("상영종료");

        private final String description;
    }

    public void changeStatusToShowing() {
        this.status = Status.SHOWING;
        showingMovie.add(this);
    }

    public void changeStatusToEndOfScreening() {
        this.status = Status.END_OF_SCREENING;
        showingMovie.remove(this);
    }


    public static Movie getMovie(String movieTitle) {

        return showingMovie.stream().filter(x -> x.getTitle().equals(movieTitle))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(ErrorType.MOVIE_ENTITY_NOT_FOUND));
    }

}

