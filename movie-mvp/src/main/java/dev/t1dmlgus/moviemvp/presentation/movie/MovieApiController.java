package dev.t1dmlgus.moviemvp.presentation.movie;

import dev.t1dmlgus.moviemvp.common.response.CommonResponse;
import dev.t1dmlgus.moviemvp.service.movie.MovieDto;
import dev.t1dmlgus.moviemvp.service.movie.MovieInfo;
import dev.t1dmlgus.moviemvp.service.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * class : 영화 API
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        영화등록 기능
 * 2022-07-26           이의현        영화상태 변경 기능
 * 2022-07-27           이의현        공통 응답 모듈 리펙토링(data<T>, message)
 * 2022-07-27           이의현        movieId(기본키) -> movieToken(대체키)
 * 2022-07-27           이의현        영화 상세정보 조회 기능
 *
 */

@RequiredArgsConstructor
@RestController
public class MovieApiController {

    private final MovieService movieService;

    @PostMapping("/api/v1/movies")
    public ResponseEntity<CommonResponse<MovieInfo>> registerMovie(@RequestBody @Valid MovieDto.RegisterMovieReq movieReq) {
        MovieInfo movieInfo = movieService.registerMovie(movieReq);
        CommonResponse<MovieInfo> response = CommonResponse.of(movieInfo, "영화가 등록되었습니다.");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/v1/movies/{movieToken}/showing")
    public ResponseEntity<CommonResponse<MovieInfo>> changeStatusToShowingMovie(@PathVariable String movieToken) {
        MovieInfo movieInfo = movieService.changeStatusToShowing(movieToken);
        CommonResponse<MovieInfo> response = CommonResponse.of(movieInfo, "해당 영화는 '상영중'으로 변경되었습니다.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/v1/movies/{movieToken}")
    public ResponseEntity<CommonResponse<MovieInfo>> getMovieInfo(@PathVariable String movieToken) {
        MovieInfo movieInfo = movieService.getMovieDetails(movieToken);
        CommonResponse<MovieInfo> response = CommonResponse.of(movieInfo, "영화 상세정보입니다.");
        return ResponseEntity.ok(response);
    }



}
