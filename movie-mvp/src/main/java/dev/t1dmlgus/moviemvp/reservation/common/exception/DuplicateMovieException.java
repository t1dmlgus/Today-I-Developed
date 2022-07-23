package dev.t1dmlgus.moviemvp.reservation.common.exception;

public class DuplicateMovieException extends BusinessException{
    public DuplicateMovieException() {
        super(ErrorType.DUPLICATED_MOVIE);
    }
}
