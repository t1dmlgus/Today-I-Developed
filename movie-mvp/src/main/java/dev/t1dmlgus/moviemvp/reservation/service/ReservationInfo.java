package dev.t1dmlgus.moviemvp.reservation.service;

import dev.t1dmlgus.moviemvp.reservation.domain.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ReservationInfo {

    private final String reservationId;
    private final String movie;
    private final String runningTime;
    private final String startTime;
    private final int totalPrice;
    private final int audience;
    private final String theater;
    private final String cinema;
    private final String theaterGrade;


    @Builder
    public ReservationInfo(String reservationId, String movie, String runningTime, String startTime, int totalPrice, int audience, String theater, String cinema, String theaterGrade) {
        this.reservationId = reservationId;
        this.movie = movie;
        this.runningTime = runningTime;
        this.startTime = startTime;
        this.totalPrice = totalPrice;
        this.audience = audience;
        this.theater = theater;
        this.cinema = cinema;
        this.theaterGrade = theaterGrade;
    }




    public static ReservationInfo from(Reservation reservation){

        return ReservationInfo.builder()
                .reservationId(reservation.getId().toString())
                .movie(reservation.getScreen().getMovie().getTitle())
                .runningTime(reservation.getScreen().getMovie().getRunningTime())
                .startTime(reservation.getScreen().getStartTime().toString())
                .totalPrice(reservation.getTotalPrice())
                .audience(reservation.getAudience())
                .theater(reservation.getScreen().getTheater().getTheaterName())
                .theaterGrade(reservation.getScreen().getTheater().getTheaterGrade().description)
                .cinema(reservation.getScreen().getTheater().getCinema().getCinemaName())
                .build();
    }
}
