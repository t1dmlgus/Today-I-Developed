package dev.t1dmlgus.moviemvp.batch;


import dev.t1dmlgus.moviemvp.common.error.ErrorType;
import dev.t1dmlgus.moviemvp.common.error.exception.EntityNotFoundException;
import dev.t1dmlgus.moviemvp.common.util.DateUtil;
import dev.t1dmlgus.moviemvp.domain.cinema.Cinema;
import dev.t1dmlgus.moviemvp.domain.movie.Movie;
import dev.t1dmlgus.moviemvp.domain.screen.Screen;
import dev.t1dmlgus.moviemvp.domain.theater.Theater;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.HashMap;

@Slf4j
@Getter
public class ScreenDto {

    private final String date;
    private final String cinemaName;
    private final String movieTitle;
    private final String theaterName;
    private final String startTime;

    public ScreenDto(String date, String cinemaName, String movieTitle, String theaterName, String startTime) {
        this.date = date;
        this.cinemaName = cinemaName;
        this.movieTitle = movieTitle;
        this.theaterName = theaterName;
        this.startTime = startTime;
    }

    public Screen toScreenEntity() {

        Movie movie = Movie.getMovie(movieTitle);

        HashMap<String, Cinema> cinemaInstances = Cinema.cinemaInstances;
        Cinema cinema = cinemaInstances.get(cinemaName);
        Theater theater = cinema.getTheaters().stream()
                .filter(x -> x.getTheaterName().equals(theaterName))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(ErrorType.THEATER_ENTITY_NOT_FOUND));

        LocalDateTime date = DateUtil.toLocalDateTime(this.date, startTime);
        // movie, theater, startTime
        return Screen.newInstance(cinema, movie, theater, date);
    }
}
