package dev.t1dmlgus.moviemvp.reservation.domain;


import dev.t1dmlgus.moviemvp.reservation.common.util.TokenUtil;
import lombok.*;

import javax.persistence.*;

@ToString
@NoArgsConstructor(force = true)
@Getter
@Entity
@Table(name = "theaters")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;

    private String theaterToken;
    private final String theaterName;
    private final int chairs;

    @Enumerated(EnumType.STRING)
    public TheaterGrade theaterGrade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;


    @RequiredArgsConstructor
    @Getter
    public enum TheaterGrade {

        GENERAL("일반관", 14000),
        SPECIAL("특별관", 20000);

        public final String description;
        public final int price;
    }


    @Builder
    private Theater(String theaterName, int chairs) {
        this.theaterName = theaterName;
        this.chairs = chairs;
        this.theaterGrade = TheaterGrade.GENERAL;
    }

    public static Theater newInstance(String theaterName, String seat){
        return Theater.builder()
                .theaterName(theaterName)
                .chairs(Integer.parseInt(seat))
                .build();
    }

    public void setCinema(Cinema cinema, int theaterNo) {
        this.cinema = cinema;
        this.theaterToken = TokenUtil.generateTheaterToken(cinema.getCinemaToken(), theaterNo);
    }


    public void changeCinemaGradeToSpecial(){
        this.theaterGrade = TheaterGrade.SPECIAL;
    }



    // 좌석선택
    public int seatSelection(int audience) {

        // 좌석 선택 로직 구현 필요
        return calculatePayment(audience);
    }



    // 결제 금액
    public int calculatePayment(int audience) {

        if (!this.theaterGrade.equals(TheaterGrade.GENERAL)) {
            return TheaterGrade.SPECIAL.getPrice() * audience;
        }
        return this.theaterGrade.getPrice() * audience;
    }

    // 상영관의 상태를 변경하고, 만드는 책임은 상영관한테 있다.(=메소드)



}
