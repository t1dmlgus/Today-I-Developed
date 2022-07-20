package dev.t1dmlgus.moviemvp.reservation;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@NoArgsConstructor
@ToString
@Getter
@Entity
@Table(name = "theaters")
public class Theater {


    public static List<Screen> todayScreenList = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long theaterId;
    public String theaterName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theater")
    private List<Cinema> cinemas = new ArrayList<>();

    public static HashMap<String, Theater> theaterInstance = new HashMap<>();

    @Builder
    public Theater(String theaterName, List<Cinema> cinemas) {
        this.theaterName = theaterName;
        this.cinemas = cinemas;
    }


    public static Theater newInstance(String theaterName, List<Cinema> cinemas) {
        Theater theater = Theater.builder()
                .theaterName(theaterName)
                .cinemas(cinemas)
                .build();

        theater.addTheaterToCinema(cinemas);
        return theater;
    }

    // 연관관계
    private void addTheaterToCinema(List<Cinema> cinemas) {
        for (Cinema cinema : cinemas) {
            cinema.setTheater(this);
        }
    }



//    public static Theater getInstance(TheaterPlace theaterPlace) {
//        // 해당 영화관이 존재할 경우 가져오고, 아니면 만듬
//
//        Theater theater = theaterInstance.get(theaterPlace.getPlace());
//        if (Objects.isNull(theater)) {
//            theater = new Theater(theaterPlace);
//            theaterInstance.put(theaterPlace.getPlace(), theater);
//            return theater;
//        }
//        return theater;
//    }


    // 상영관 좌석선택 & 결제
//    public int getChair(int audience, int round) {
//        for (Cinema cinema : cinemas) {
//            boolean b = cinema.getRound() == round;
//            if(b)
//                return cinema.seatSelection(audience, cinema.theaterType.description);
//        }
//        throw new RuntimeException("해당 상영관을 찾을 수 없습니다.");
//    }


    public void todayScreenList(List<ScreenDtos> screenDtos) {


    }



}
