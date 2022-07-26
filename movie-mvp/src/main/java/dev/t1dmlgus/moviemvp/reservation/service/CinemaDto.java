package dev.t1dmlgus.moviemvp.reservation.service;


import dev.t1dmlgus.moviemvp.reservation.domain.Cinema;
import dev.t1dmlgus.moviemvp.reservation.domain.Theater;
import lombok.Getter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * class : 영화관 DTO
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        영화관 등록 DTO 구현
 * 2022-07-26           이의현        상영관 등록 DTO 구현
 * 2022-07-26           이의현        @Valid 추가 **
 *
 */
public class CinemaDto {

    @ToString
    @Getter
    public static class RegisterCinemaRequest{
        @NotBlank(message = "영화관명은 필수 값입니다.")
        private String cinemaName;
        @NotBlank(message = "지역명은 필수 값입니다.")
        private String area;

        @Valid
        private List<RegisterTheaterRequest> theaters;

        public Cinema toCinemaEntity(){

            ArrayList<Theater> theaterEntities = new ArrayList<>();
            for (RegisterTheaterRequest requestTheater : theaters) {
                theaterEntities.add(requestTheater.toTheaterEntity());
            }
            return Cinema.newInstance(cinemaName, theaterEntities, area);
        }
    }

    @ToString
    @Getter
    public static class RegisterTheaterRequest {

        @NotBlank(message = "상영관명을 입력해주세요.")
        private String theaterNo;
        @NotBlank(message = "좌석수를 입력해주세요")
        private String seat;

        public Theater toTheaterEntity(){
            return Theater.newInstance(theaterNo, seat);
        }
    }
}