package dev.t1dmlgus.moviemvp;

import dev.t1dmlgus.moviemvp.domain.cinema.CinemaRepository;
import dev.t1dmlgus.moviemvp.domain.movie.Movie;
import dev.t1dmlgus.moviemvp.domain.movie.MovieRepository;
import dev.t1dmlgus.moviemvp.service.cinema.CinemaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class CinemaServiceTest {


    @Autowired
    CinemaService cinemaService;

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    MovieRepository movieRepository;

    // mockitoStatic 사용할 것


    @BeforeEach
//    TodayScreenListDto todayScreenListDto =
//            new TodayScreenListDto("20220721","안양",
//                    List.of(new TodayScreenListDto.MovieDto("미니언즈2",
//                                    List.of(new TodayScreenListDto.TheaterDetail("7관","0935"),
//                                            new TodayScreenListDto.TheaterDetail("4관","1030"),
//                                            new TodayScreenListDto.TheaterDetail("6관","1155"),
//                                            new TodayScreenListDto.TheaterDetail("4관","1450"),
//                                            new TodayScreenListDto.TheaterDetail("6관","1545")
//                                    )
//                            ),
//                            new TodayScreenListDto.MovieDto("외계+인 1부",
//                                    List.of(new TodayScreenListDto.TheaterDetail("5관","1050"),
//                                            new TodayScreenListDto.TheaterDetail("7관","1130"),
//                                            new TodayScreenListDto.TheaterDetail("1관","1215"),
//                                            new TodayScreenListDto.TheaterDetail("3관","1300"),
//                                            new TodayScreenListDto.TheaterDetail("5관","1340")
//                                    )
//                            )
//                    )
//            );


//    CinemaCommand cinemaCommand = new CinemaCommand("안양",
//            List.of(
//                    new CinemaCommand.TheaterDto("1관", 228),
//                    new CinemaCommand.TheaterDto("2관", 153),
//                    new CinemaCommand.TheaterDto("3관", 129),
//                    new CinemaCommand.TheaterDto("4관", 96),
//                    new CinemaCommand.TheaterDto("5관", 129),
//                    new CinemaCommand.TheaterDto("6관", 153),
//                    new CinemaCommand.TheaterDto("7관", 228)
//            ));


    @Test
    void createTheater(){

//        cinemaService.createCinema();
//        cinemaService.todayScreenInit();
//
//        Screen screen = cinemaService.screenByTheater("안양");
//
//
//        int audience = 2;
//        cinemaService.reservation(audience, screen);
//        cinemaService.checkReservationOfMovie();
    }

    @Test
    void createScreen(){

//        TodayScreenListDto todayScreenListDto =
//                new TodayScreenListDto("20220721","안양",
//                        List.of(new TodayScreenListDto.MovieDto("미니언즈2",
//                                        List.of(new TodayScreenListDto.TheaterDetail("7관","0935"),
//                                                new TodayScreenListDto.TheaterDetail("4관","1030"),
//                                                new TodayScreenListDto.TheaterDetail("6관","1155"),
//                                                new TodayScreenListDto.TheaterDetail("4관","1450"),
//                                                new TodayScreenListDto.TheaterDetail("6관","1545")
//                                        )
//                                ),
//                                new TodayScreenListDto.MovieDto("외계+인 1부",
//                                        List.of(new TodayScreenListDto.TheaterDetail("5관","1050"),
//                                                new TodayScreenListDto.TheaterDetail("7관","1130"),
//                                                new TodayScreenListDto.TheaterDetail("1관","1215"),
//                                                new TodayScreenListDto.TheaterDetail("3관","1300"),
//                                                new TodayScreenListDto.TheaterDetail("5관","1340")
//                                        )
//                                )
//                        )
//                );

        List<Movie> movies = movieRepository.findAll();

//        cinemaService.todayScreenInit();
    }

}