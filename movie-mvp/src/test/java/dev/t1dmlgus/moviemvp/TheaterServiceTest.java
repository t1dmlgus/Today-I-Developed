package dev.t1dmlgus.moviemvp;

import dev.t1dmlgus.moviemvp.reservation.Cinema;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
class TheaterServiceTest {


    @Autowired
    TheaterService theaterService;

    @Autowired
    CinemaRepository cinemaRepository;


    @Test
    void createTheater(){

        theaterService.createTheater();

    }

    @Test
    void createScreen(){

        theaterService.createScreen();
    }

}