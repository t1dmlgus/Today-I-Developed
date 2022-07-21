package dev.t1dmlgus.moviemvp.reservation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@NoArgsConstructor(force = true)
@Getter
@Table(name = "movies")
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private final String title;
    private final String runningTime;

    public Movie(String title, String runningTime) {
        this.title = title;
        this.runningTime = runningTime;
    }

    //    영화가 계속 생성된다.
//    public Movie getMovie(String movieTile) {
//        return new Movie(movieTile);
//    }



}
