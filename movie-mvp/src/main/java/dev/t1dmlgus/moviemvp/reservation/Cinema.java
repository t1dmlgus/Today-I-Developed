package dev.t1dmlgus.moviemvp.reservation;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(force = true)
@ToString(exclude = "theater")
@Getter
@Table(name = "cinemas")
@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cinemaId;
    private final String cinemaName;
    private final int chairs;

    @Enumerated(EnumType.STRING)
    public CinemaGrade cinemaGrade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id")
    private Theater theater;


    @RequiredArgsConstructor
    @Getter
    public enum CinemaGrade{

        GENERAL("일반관", 14000),
        SPECIAL("특별관", 20000);

        public final String description;
        public final int price;
    }


    @Builder
    public Cinema(String cinemaName, int chairs) {
        this.cinemaName = cinemaName;
        this.chairs = chairs;
        this.cinemaGrade = CinemaGrade.GENERAL;
    }

    public static Cinema newInstance(String cinemaName, int chairs){
        return Cinema.builder()
                .cinemaName(cinemaName)
                .chairs(chairs)
                .build();
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void changeCinemaGrade(){
        this.cinemaGrade = CinemaGrade.SPECIAL;
    }



//    // 좌석선택
//    public int seatSelection(int audience, String theaterType) {
//        chairs -= audience;
//        return payment(audience, theaterType);
//    }
//    // 결제
//
//    public int payment(int audience, String theaterType) {
//
//        if (TheaterType.SPECIAL.description.equals(theaterType)) {
//            return TheaterType.SPECIAL.getPrice() * audience;
//        }
//        return TheaterType.BASIC.getPrice() * audience;
//    }

    // 상영관을 만드는 책임(=메소드)



}
