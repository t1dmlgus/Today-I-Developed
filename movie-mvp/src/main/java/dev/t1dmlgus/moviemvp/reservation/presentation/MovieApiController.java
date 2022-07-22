package dev.t1dmlgus.moviemvp.reservation.presentation;

import dev.t1dmlgus.moviemvp.reservation.common.response.CommonResponse;
import dev.t1dmlgus.moviemvp.reservation.service.MovieService;
import dev.t1dmlgus.moviemvp.reservation.service.MovieToRegisterCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class MovieApiController {

    private final MovieService movieService;

    @PostMapping("/api/v1/movies")
    public ResponseEntity<CommonResponse<String>> registerMovie(@RequestBody MovieToRegisterCommand movieToRegisterCommand) {
        movieService.registerMovie(movieToRegisterCommand);
        CommonResponse<String> response = CommonResponse.of("영화가 등록되었습니다.");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/v1/movies/{movieId}/showing")
    public ResponseEntity<CommonResponse<String>> changingShowingMovie(@PathVariable Long movieId) {
        movieService.toShowingMovie(movieId);
        CommonResponse<String> response = CommonResponse.of("해당 영화는 '상영중'으로 변경되었습니다.");
        return ResponseEntity.ok(response);
    }

}
