package dev.t1dmlgus.moviemvp;

import dev.t1dmlgus.moviemvp.reservation.domain.*;
import dev.t1dmlgus.moviemvp.service.TheaterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TheaterServiceTest {


    @Autowired
    TheaterService theaterService;

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    MovieRepository movieRepository;

    // mockitoStatic 사용할 것


    @Test
    void createTheater(){

        theaterService.createTheater();
        theaterService.todayScreen();

        Screen screen = theaterService.screenByTheater("안양");


        int audience = 2;
        theaterService.reservation(audience, screen);
        theaterService.checkReservationOfMovie();
    }

    @Test
    void createScreen(){

        ScreenDtos screenDtos =
                new ScreenDtos("20220721","안양",
                        List.of(new ScreenDtos.MovieDto("미니언즈2",
                                        List.of(new ScreenDtos.CinemaDetail("7관","0935"),
                                                new ScreenDtos.CinemaDetail("4관","1030"),
                                                new ScreenDtos.CinemaDetail("6관","1155"),
                                                new ScreenDtos.CinemaDetail("4관","1450"),
                                                new ScreenDtos.CinemaDetail("6관","1545")
                                        )
                                ),
                                new ScreenDtos.MovieDto("외계+인 1부",
                                        List.of(new ScreenDtos.CinemaDetail("5관","1050"),
                                                new ScreenDtos.CinemaDetail("7관","1130"),
                                                new ScreenDtos.CinemaDetail("1관","1215"),
                                                new ScreenDtos.CinemaDetail("3관","1300"),
                                                new ScreenDtos.CinemaDetail("5관","1340")
                                        )
                                )
                        )
                );

        List<Movie> movies = movieRepository.findAll();

        theaterService.todayScreen();
    }

}