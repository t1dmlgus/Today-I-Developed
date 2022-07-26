package dev.t1dmlgus.moviemvp.reservation.service;


import dev.t1dmlgus.moviemvp.reservation.common.exception.EntityNotFoundException;
import dev.t1dmlgus.moviemvp.reservation.common.exception.ErrorType;
import dev.t1dmlgus.moviemvp.reservation.common.exception.DuplicateException;
import dev.t1dmlgus.moviemvp.reservation.domain.Movie;
import dev.t1dmlgus.moviemvp.reservation.domain.MovieRepository;
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
 *
 */
@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public void registerMovie(MovieDto.RegisterMovieReq movieReq) {

        if (isExistMovie(movieReq.getTitle())) {
            throw new DuplicateException(ErrorType.MOVIE_ENTITY_NOT_FOUND);
        }
        movieRepository.save(movieReq.toMovieEntity());
    }

    @Transactional
    public void changeStatusToShowing(Long movieId) {

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(()-> new EntityNotFoundException(ErrorType.MOVIE_ENTITY_NOT_FOUND));
        // 변경감지
        movie.changeStatusToShowing();
    }

    @Transactional(readOnly = true)
    public boolean isExistMovie(String movieTitle){
        return movieRepository.existsByTitle(movieTitle);
    }
}
