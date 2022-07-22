package dev.t1dmlgus.moviemvp.reservation.service;

import dev.t1dmlgus.moviemvp.reservation.domain.Movie;
import lombok.Getter;

@Getter
public class MovieToRegisterCommand {

    private String title;
    private String runningTime;

    public Movie toMovieEntity() {
        return Movie.builder()
                .title(title)
                .runningTime(runningTime)
                .build();
    }
}
