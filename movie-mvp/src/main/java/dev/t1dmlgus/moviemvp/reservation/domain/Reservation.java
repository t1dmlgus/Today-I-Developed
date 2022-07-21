package dev.t1dmlgus.moviemvp.reservation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor(force = true)
@ToString
@Getter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final int audience;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private final Screen screen;


    private final int totalPrice;

    public Reservation(int audience, Screen screen, int totalPrice) {
        this.audience = audience;
        this.screen = screen;
        this.totalPrice = totalPrice;
    }

//    public int discount(Screen screen, int totalPrice) {
//        return Discount.discount(screen, totalPrice);
//    }


}

