package dev.t1dmlgus.moviemvp.reservation.service;

import dev.t1dmlgus.moviemvp.reservation.domain.Movie;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class MovieToRegisterCommand {

    @NotBlank(message = "영화 제목 입력은 필수입니다.")
    private String title;

    @NotBlank(message = "영화 러닝타입 입력은 필수입니다.")
    private String runningTime;

    public Movie toMovieEntity() {
        return Movie.builder()
                .title(title)
                .runningTime(runningTime)
                .build();
    }
}
