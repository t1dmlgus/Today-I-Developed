package dev.t1dmlgus.moviemvp.service.reservation;


import dev.t1dmlgus.moviemvp.common.error.ErrorType;
import dev.t1dmlgus.moviemvp.common.error.exception.EntityNotFoundException;
import dev.t1dmlgus.moviemvp.common.util.DateUtil;
import dev.t1dmlgus.moviemvp.domain.cinema.Cinema;
import dev.t1dmlgus.moviemvp.domain.screen.Screen;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * class : 예매 요청 DTO
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        예매 요청 DTO
 * 2022-07-26           이의현        요청한 상영 존재 확인
 *
 */

public class ReserveDto {
    @ToString
    @Getter
    public static class ScreenReq {
        @NotBlank(message = "영화관을 입력해주세요.")
        private String cinemaName;
        @NotBlank(message = "영화명을 입력해주세요.")
        private String movieTitle;
        @NotBlank(message = "상영 날짜을 입력해주세요.")
        private String date;
        @NotBlank(message = "상영 시간을 입력해주세요.")
        private String time;

        @NotNull(message = "인원을 입력해주세요")
        private int audience;

        public Screen getScreenFromCinema() {

            Cinema cinema = Cinema.cinemaInstances.get(getCinemaName());
            // 영화 찾기, 1) 영화로 선별, 2) 시간으로 선별
            if(cinema != null){
                return cinema.getScreens().stream()
                        .filter(i -> i.getMovie().getTitle().equals(movieTitle))
                        .filter(i -> i.getStartTime().equals(DateUtil.toLocalDateTime(date, time)))
                        .findFirst()
                        .orElseThrow(()->new EntityNotFoundException(ErrorType.SCREEN_ENTITY_NOT_FOUND));
                // (추가적으로) 해당 상영은 예매할 수 없습니다.
            }
            throw new EntityNotFoundException(ErrorType.CINEMA_ENTITY_NOT_FOUND);
        }
    }
}
