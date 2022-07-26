package dev.t1dmlgus.moviemvp.reservation.service;

import dev.t1dmlgus.moviemvp.reservation.domain.Movie;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 *
 * class : 영화 DTO
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        영화등록 DTO
 *
 */

public class MovieDto {

    @ToString
    @Getter
    public static class RegisterMovieReq {
        @NotBlank(message = "영화명 입력은 필수입니다.")
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
}
