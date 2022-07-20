package dev.t1dmlgus.moviemvp;

import dev.t1dmlgus.moviemvp.reservation.Theater;
import dev.t1dmlgus.moviemvp.reservation.TheaterPlace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieMvpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieMvpApplication.class, args);

//		Theater theater = Theater.getInstance(TheaterPlace.ANYANG);
//		Theater theater2 = Theater.getInstance(TheaterPlace.BUMGAE);
//		Theater theater1 = Theater.getInstance(TheaterPlace.ANYANG);




	}

}
