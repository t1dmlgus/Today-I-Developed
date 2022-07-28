package dev.t1dmlgus.moviemvp.service.movie;

import dev.t1dmlgus.moviemvp.domain.movie.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * class : 영화 응답 DTO
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-27           이의현        영화 등록, 상세조회
 *
 */
@ToString
@Getter
public class MovieInfo {

    private final String movieToken;
    private final String movieTitle;
    private final String runningTime;
    private final String movieStatus;

    @Builder
    private MovieInfo(String movieToken, String movieTitle, String runningTime, String movieStatus) {
        this.movieToken = movieToken;
        this.movieTitle = movieTitle;
        this.runningTime = runningTime;
        this.movieStatus = movieStatus;
    }

    public static MovieInfo from(Movie movie) {
        return MovieInfo.builder()
                .movieToken(movie.getMovieToken())
                .movieTitle(movie.getTitle())
                .runningTime(movie.getRunningTime())
                .movieStatus(movie.getStatus().getDescription())
                .build();
    }

    public static MovieInfo getToken(String movieToken) {
        return MovieInfo.builder()
                .movieToken(movieToken)
                .build();
    }
}
