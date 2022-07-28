package dev.t1dmlgus.moviemvp.domain.screen;

import lombok.Getter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * class : 상영시간표 DTO
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        유효성검사 & @Valid
 *
 */

@ToString
@Getter
public class ScreenSchedule {

    @NotBlank(message = "일정을 입력해주세요")
    private String date;
    @NotBlank(message = "영화관 이름을 입력해주세요")
    private String cinemaName;
    @Valid
    private List<ScreenOnMovie> screenOnMovies;


    @ToString
    @Getter
    public static class ScreenOnMovie {

        @NotBlank(message = "영화제목을 입력해주세요")
        private String movieTitle;
        @Valid
        private List<TheaterOfScreenMovie> theaterOfScreenMovies;

    }

    @ToString
    @Getter
    public static class TheaterOfScreenMovie {

        @NotBlank(message = "상영관명을 입력해주세요")
        private String theaterName;
        @NotBlank(message = "시작시간을 입력해주세요")
        private String startTime;
    }

}
