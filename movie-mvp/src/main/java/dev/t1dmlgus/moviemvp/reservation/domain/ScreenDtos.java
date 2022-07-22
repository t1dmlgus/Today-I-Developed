package dev.t1dmlgus.moviemvp.reservation.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
public class ScreenDtos {

    private String date;
    private String theaterName;
    private List<MovieDto> movieDtos;

    public ScreenDtos(String date, String theaterName, List<MovieDto> movieDtos) {
        this.date = date;
        this.theaterName = theaterName;
        this.movieDtos = movieDtos;
    }

    @Getter
    public static class MovieDto{

        private String movieTitle;
        private List<CinemaDetail> cinemaDetails;

        public MovieDto(String movieTitle, List<CinemaDetail> cinemaDetails) {
            this.movieTitle = movieTitle;
            this.cinemaDetails = cinemaDetails;
        }
    }

    @Getter
    public static class CinemaDetail{

        private String cinema;
        private String startTime;

        public CinemaDetail(String cinema, String startTime) {
            this.cinema = cinema;
            this.startTime = startTime;
        }
    }

}
