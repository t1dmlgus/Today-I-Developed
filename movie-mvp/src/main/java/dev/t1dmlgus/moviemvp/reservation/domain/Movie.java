package dev.t1dmlgus.moviemvp.reservation.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor(force = true)
@Getter
@Entity
@Table(name = "movies")
public class Movie {

    public static List<Movie> showingMovie = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private final String title;
    private final String runningTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Builder
    private Movie(String title, String runningTime) {
        this.title = title;
        this.runningTime = runningTime;
        this.status = Status.BEFORE_SCREENING;
    }

    public static Movie newInstance(String title, String runningTime) {
         return Movie.builder()
                .title(title)
                .runningTime(runningTime)
                .build();
    }

     @Getter
     @RequiredArgsConstructor
     public enum Status{

         SHOWING("상영중"),
         BEFORE_SCREENING("상영전"),
         END_OF_SCREENING("상영종료");

         private final String description;
     }

     public void changeStatusToShowing(){
         this.status = Status.SHOWING;
         showingMovie.add(this);
     }

    public void changeStatusToEndOfScreening(){
        this.status = Status.END_OF_SCREENING;
        showingMovie.remove(this);
    }


}
