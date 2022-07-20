package dev.t1dmlgus.moviemvp.reservation;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "screens")
@Entity
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screenId;

    private final String movieName;
    private final int cinemaNo;
    private final int extraSeat ;
    private final int seat;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private final Movie movie;                          // 영화 별

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private final Theater theater;                      // 영화관 별

    private final LocalDateTime startTime;              // 시간 별


    @Builder
    private Screen(Movie movie, Theater theater,int cinemaNo, LocalDateTime startTime) {
        this.movieName = movie.getTitle();
        this.cinemaNo = cinemaNo;
        this.extraSeat = theater.getCinemas().get(cinemaNo).getChairs();
        this.seat = theater.getCinemas().get(cinemaNo).getChairs();
        this.movie = movie;
        this.theater = theater;
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
    public static Screen todayScreenInitByTheater(Theater theater, Movie movie, int cinemaNo, LocalDateTime localDateTime) {

        return Screen.builder()
                .theater(theater)
                .movie(movie)
                .cinemaNo(cinemaNo)
                .startTime(localDateTime)
                .build();

    }


//
//    public Screen getScreen(int round){
//        if (this.getRound() == round) {
//            return this;
//        }
//        throw new RuntimeException("해당 회차는 없습니다.");
//    }


    public void reservation(int audience, String theaterType, String name, int round, String movieTile){

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