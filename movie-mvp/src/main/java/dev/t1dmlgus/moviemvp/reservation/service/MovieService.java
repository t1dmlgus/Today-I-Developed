package dev.t1dmlgus.moviemvp.reservation.service;


import dev.t1dmlgus.moviemvp.reservation.common.exception.EntityNotFoundException;
import dev.t1dmlgus.moviemvp.reservation.common.exception.ErrorType;
import dev.t1dmlgus.moviemvp.reservation.common.exception.movie.DuplicateMovieException;
import dev.t1dmlgus.moviemvp.reservation.domain.Movie;
import dev.t1dmlgus.moviemvp.reservation.domain.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional
    public void registerMovie(MovieToRegisterCommand movieToRegisterCommand) {

        if (isExistMovie(movieToRegisterCommand.getTitle())) {
            throw new DuplicateMovieException();
        }
        movieRepository.save(movieToRegisterCommand.toMovieEntity());
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
