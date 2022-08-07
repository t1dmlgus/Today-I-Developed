package dev.t1dmlgus.moviemvp.service.cinema;


import lombok.Getter;

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
}
