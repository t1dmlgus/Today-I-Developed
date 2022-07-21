package dev.t1dmlgus.moviemvp.reservation.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(force = true)
@ToString
@Getter
@Table(name = "screens")
@Entity
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenId;

    private int extraSeat ;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private final Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private final Movie movie;                          // 영화 별

//    @ManyToOne
//    @JoinColumn(name = "theater_id")
//    private final Theater theater;                      // 영화관 별

    private final LocalDateTime startTime;              // 시간 별


    @Builder
    public Screen(Movie movie, Cinema cinema, LocalDateTime startTime) {
        this.extraSeat = cinema.getChairs();
        this.cinema = cinema;
        this.movie = movie;
        this.startTime = startTime;
    }

    //
//    public void initScreen(Theater theater, Movie movie) {
//        int round = 5;  // 회차
//        // 시간
////        int chair = 60;
//        // 1회차, 60석
//        // 2회차, 30석
//        // 3회차, 6석
//        // 4회차, 70석
//        // 5회차 390석
//
//        for (int i = 0; i < round; i++) {
//            new Screen(theater, movie, i);
//        }
//    }

    // 금일 상영시간표 생성
//    public static Screen todayScreenInitByTheater(Theater theater, Movie movie, int cinemaNo, LocalDateTime localDateTime) {
//
//        return Screen.builder()
//                .theater(theater)
//                .movie(movie)
//                .cinemaNo(cinemaNo-1)
//                .startTime(localDateTime)
//                .build();
//
//    }


//
//    public Screen getScreen(int round){
//        if (this.getRound() == round) {
//            return this;
//        }
//        throw new RuntimeException("해당 회차는 없습니다.");
//    }


    public Reservation reservation(int audience){

        // 결제금액
        int totalPriceOfAudience = this.getCinema().seatSelection(audience);

        // 변경감지 **

        // 잔여좌석
        extraSeat -= audience;
        // 예매생성
        return new Reservation(audience, this, totalPriceOfAudience);


//        theater = Theater.getTheater(name);         // 영화관 선택
//        movie = Movie.getMovie(movieTile);          // 영화 선택
        // 인원선택
        // 상영회차 선택(3회차 - 2상영관)
//        Screen screen = getScreen(round);


        // 좌석선택 & 금액 산출
//        int chairPayment = theater.getChair(audience, round);


        // 초기화
        //initScreen(theater, movie);
//        new Reservation(audience, screen, chairPayment);
    }
}