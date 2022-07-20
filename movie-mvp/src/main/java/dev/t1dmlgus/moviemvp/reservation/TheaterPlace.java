package dev.t1dmlgus.moviemvp.reservation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum TheaterPlace {

        ANYANG("안양", 5, new ArrayList<>()),
        BUMGAE("범계", 3, new ArrayList<>());

        private final String place;
        private final int numberOfCinema;
        private final List<Cinema> cinemas;

}
