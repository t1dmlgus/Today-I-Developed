package dev.t1dmlgus.moviemvp.reservation.service;

import dev.t1dmlgus.moviemvp.reservation.domain.Cinema;
import dev.t1dmlgus.moviemvp.reservation.domain.Theater;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public class CinemaInfo {

    private final String cinemaName;
    private final List<TheaterOfCinema> theatersOfCinema;


    @Builder
    private CinemaInfo(String cinemaName, List<TheaterOfCinema> theatersOfCinema) {
        this.cinemaName = cinemaName;
        this.theatersOfCinema = theatersOfCinema;
    }


    @Getter
    public static class TheaterOfCinema {
        private final String theaterNo;
        private final int seat;

        @Builder
        private TheaterOfCinema(String theaterNo, int seat) {
            this.theaterNo = theaterNo;
            this.seat = seat;
        }

        public static TheaterOfCinema newInstance(String theaterNo, int seat) {
            return TheaterOfCinema.builder()
                    .theaterNo(theaterNo)
                    .seat(seat)
                    .build();
        }

    }

    public static CinemaInfo of(Cinema cinema){

        List<TheaterOfCinema> theaterOfCinemas = new ArrayList<>();
        for (Theater theater : cinema.getTheaters()) {
            theaterOfCinemas.add(TheaterOfCinema.newInstance(theater.getTheaterName(), theater.getChairs()));
;        }

        return CinemaInfo.builder()
                .cinemaName(cinema.getCinemaName())
                .theatersOfCinema(theaterOfCinemas)
                .build();

    }
}
