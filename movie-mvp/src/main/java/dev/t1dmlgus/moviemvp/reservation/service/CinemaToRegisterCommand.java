package dev.t1dmlgus.moviemvp.reservation.service;


import dev.t1dmlgus.moviemvp.reservation.domain.Cinema;
import dev.t1dmlgus.moviemvp.reservation.domain.Theater;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class CinemaToRegisterCommand {

    private String cinema;
    private List<TheaterCommand> theaterCommands;


    @NoArgsConstructor
    @Getter
    public static class TheaterCommand {

        private String theaterNo;
        private int seat;

        public Theater toTheaterEntity(){
            return Theater.newInstance(theaterNo, seat);
        }
    }


    public Cinema toEntity() {

        ArrayList<Theater> theaters = new ArrayList<>();
        for (TheaterCommand theaterCommand : theaterCommands) {
            theaters.add(theaterCommand.toTheaterEntity());
        }
        return Cinema.newInstance(cinema, theaters);
    }
}
