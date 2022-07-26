package dev.t1dmlgus.moviemvp.reservation.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
/**
 *
 * class : 예약 Domain
 * version 1.0
 * =========================================================
 * DATE                 DEVELOPER   NOTE
 * =========================================================
 * 2022-07-26           이의현       예약 생성(인원, 상영, 총 금액)
 *
 *
 */
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

}

