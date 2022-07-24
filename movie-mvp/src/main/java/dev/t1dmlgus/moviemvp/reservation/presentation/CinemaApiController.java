package dev.t1dmlgus.moviemvp.reservation.presentation;


import dev.t1dmlgus.moviemvp.reservation.common.response.CommonResponse;
import dev.t1dmlgus.moviemvp.reservation.domain.Movie;
import dev.t1dmlgus.moviemvp.reservation.domain.ScreenSchedule;
import dev.t1dmlgus.moviemvp.reservation.domain.Theater;
import dev.t1dmlgus.moviemvp.reservation.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
public class CinemaApiController {

    private final CinemaService cinemaService;

    @PostMapping("/api/v1/cinemas")
    public ResponseEntity<CommonResponse<String>> createCinema(@RequestBody CinemaToRegisterCommand cinemaToRegisterCommand){

        CinemaInfo<Theater> cinemaInfo = cinemaService.createCinema(cinemaToRegisterCommand);
        CommonResponse<String> response = CommonResponse.of(cinemaInfo.cinemaResponse());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/v1/cinemas/screens")
    public ResponseEntity<CommonResponse<String>> initTodayScreen(@RequestBody ScreenSchedule screenSchedule){

        CinemaInfo<Movie> cinemaInfo = cinemaService.todayScreenInit(screenSchedule);
        CommonResponse<String> response = CommonResponse.of(cinemaInfo.cinemaResponse());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/v1/cinemas/1/reservation/{audience}")
    public ResponseEntity<CommonResponse<ReservationInfo>> reservationMovie(@PathVariable int audience, @RequestBody ScreenToReserveCommand screenToReserveCommand){

        // 어디 영화관, 어떤영화, 몇시
        // 좌석체크 후
        // 예매가능

        ReservationInfo reservationInfo = cinemaService.reservation(audience, screenToReserveCommand);
        CommonResponse<ReservationInfo> response = CommonResponse.of(reservationInfo, "예매 완료되었습니다.");
        return ResponseEntity.ok(response);
    }
}
