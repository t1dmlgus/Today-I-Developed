package dev.t1dmlgus.moviemvp.service.movie;

import dev.t1dmlgus.moviemvp.common.error.exception.DuplicateException;
import dev.t1dmlgus.moviemvp.common.error.exception.EntityNotFoundException;
import dev.t1dmlgus.moviemvp.domain.movie.Movie;
import dev.t1dmlgus.moviemvp.domain.movie.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 *
 * class : 영화 Service test
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-30           이의현        영화등록, 영화등록 실패
 *                                  영화상세조회, 영화상세조회 실패
 *                                  영화중복확인, 영화상태변경
 *
 */
@ExtendWith(MockitoExtension.class)
class MovieServiceTest {


    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    private MovieDto.RegisterMovieReq registerMovieReq;
    private Movie movie;

    @BeforeEach
    void setUp(){
        registerMovieReq = new MovieDto.RegisterMovieReq("미니언즈 2", "138");
        movie = Movie.newInstance("미니언즈 2", "138");
    }


    @DisplayName("영화 등록")
    @Test
    void registerMovie() {

        // given

        // when
        when(movieRepository.existsByTitle(any(String.class))).thenReturn(false);
        when(movieRepository.save(any(Movie.class))).thenReturn(movie);
        MovieInfo movieInfo = movieService.registerMovie(registerMovieReq);

        // then
        assertThat(movieInfo.getMovieToken())
                .isEqualTo(movie.getMovieToken());
    }

    @DisplayName("영화 등록 실패")
    @Test
    void registerMovieDuplicatedException() {

        // given

        // when
        when(movieRepository.existsByTitle(any(String.class))).thenReturn(true);

        // then
        assertThatThrownBy(() -> movieService.registerMovie(registerMovieReq))
                .isInstanceOf(DuplicateException.class);
    }

    @DisplayName("영화 상태 변경")
    @Test
    void changeStatusToShowing() {

        //given
        String movieToken = movie.getMovieToken();

        // when
        when(movieRepository.findByMovieToken(any(String.class)))
                .thenReturn(Optional.ofNullable(movie));
        MovieInfo movieInfo = movieService.changeStatusToShowing(movieToken);

        // then
        assertThat(movieInfo.getMovieToken())
                .isEqualTo(movieToken);
    }

    @DisplayName("영화 중복 확인")
    @Test
    void isExistMovie(){

        //given

        // when
        when(movieRepository.existsByTitle(any(String.class)))
                .thenReturn(true);
        boolean existMovie = movieService.isExistMovie(movie.getTitle());

        // then
        assertThat(existMovie).isEqualTo(true);
    }


    @DisplayName("영화 상세 조회")
    @Test
    void getMovieDetails(){

        //given

        // when
        when(movieRepository.findByMovieToken(any(String.class)))
                .thenReturn(Optional.ofNullable(movie));
        MovieInfo movieDetails = movieService.getMovieDetails(movie.getMovieToken());

        // then
        assertThat(movieDetails.getMovieTitle()).isEqualTo("미니언즈 2");
    }


    @DisplayName("영화 상세 조회 실패")
    @Test
    void getMovieDetailsEntityNotFoundException(){

        //given

        // when
        when(movieRepository.findByMovieToken(any(String.class)))
                .thenReturn(Optional.empty());

        // then
        assertThatThrownBy(() -> movieService.getMovieDetails(movie.getTitle()))
                .isInstanceOf(EntityNotFoundException.class);

    }


}