package dev.t1dmlgus.moviemvp.domain.screen;

import dev.t1dmlgus.moviemvp.domain.cinema.Cinema;
import dev.t1dmlgus.moviemvp.domain.movie.Movie;
import dev.t1dmlgus.moviemvp.domain.reservation.Reservation;
import dev.t1dmlgus.moviemvp.domain.theater.Theater;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * class : 상영 Domain
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ===============================================================
 * 2022-07-26           이의현        정적 팩토리 메서드 구현
 * 2022-07-26           이의현        예매 비즈니스 로직 생성
 * 2022-07-26           이의현        @NoArgsConstructor(force = true) final 타입 초기화
 *
 *
 */

@NoArgsConstructor(force = true)
@ToString
@Getter
@Entity
@Table(name = "screens")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenId;

    private int extraSeat ;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private final Cinema cinema;


    @ManyToOne
    @JoinColumn(name = "theater_id")
    private final Theater theater;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private final Movie movie;                          // 영화 별
    private final LocalDateTime startTime;              // 시간 별


    @Builder
    private Screen(Cinema cinema, Movie movie, Theater theater, LocalDateTime startTime) {
        this.extraSeat = theater.getChairs();
        this.cinema = cinema;
        this.theater = theater;
        this.movie = movie;
        this.startTime = startTime;
    }

    public static Screen newInstance(Cinema cinema, Movie movie, Theater theater, LocalDateTime startTime){
        return Screen.builder()
                .cinema(cinema)
                .movie(movie)
                .theater(theater)
                .startTime(startTime)
                .build();
    }


    public Reservation reservation(int audience){

        // 결제금액
        int totalPriceOfAudience = this.getTheater().seatSelection(audience);

        // 잔여좌석(변경감지)
        countExtraSeat(audience);

        // 예매생성
        return new Reservation(audience, this, totalPriceOfAudience);
    }

    private void countExtraSeat(int audience) {
        extraSeat -= audience;
    }
}