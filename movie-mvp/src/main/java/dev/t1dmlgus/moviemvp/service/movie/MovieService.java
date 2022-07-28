package dev.t1dmlgus.moviemvp.service.movie;


import dev.t1dmlgus.moviemvp.common.error.ErrorType;
import dev.t1dmlgus.moviemvp.common.error.exception.DuplicateException;
import dev.t1dmlgus.moviemvp.common.error.exception.EntityNotFoundException;
import dev.t1dmlgus.moviemvp.domain.movie.Movie;
import dev.t1dmlgus.moviemvp.domain.movie.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * class : 영화 Service
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        영화 등록 서비스
 * 2022-07-26           이의현        영화상태 변경 서비스
 * 2022-07-26           이의현        영화 중복 확인
 * 2022-07-27           이의현        영화 상세정보 조회 서비스
 * 2022-07-27           이의현        기본키(movieId) -> 대체키(movieToken)
 *
 */
@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public MovieInfo registerMovie(MovieDto.RegisterMovieReq movieReq) {

        if (isExistMovie(movieReq.getTitle())) {
            throw new DuplicateException(ErrorType.DUPLICATED_MOVIE);
        }
        Movie registeredMovie = movieRepository.save(movieReq.toMovieEntity());
        return MovieInfo.getToken(registeredMovie.getMovieToken());
    }

    @Transactional
    public MovieInfo changeStatusToShowing(String movieToken) {

        Movie movie = movieRepository.findByMovieToken(movieToken)
                .orElseThrow(()-> new EntityNotFoundException(ErrorType.MOVIE_ENTITY_NOT_FOUND));
        // 변경감지
        movie.changeStatusToShowing();
        return MovieInfo.getToken(movie.getMovieToken());
    }

    @Transactional(readOnly = true)
    public boolean isExistMovie(String movieTitle){
        return movieRepository.existsByTitle(movieTitle);
    }


    @Transactional(readOnly = true)
    public MovieInfo getMovieDetails(String movieToken){
        Movie movie = movieRepository.findByMovieToken(movieToken)
                .orElseThrow(() -> new EntityNotFoundException(ErrorType.MOVIE_ENTITY_NOT_FOUND));
        return MovieInfo.from(movie);
    }
}
