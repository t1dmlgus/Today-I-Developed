package dev.t1dmlgus.moviemvp.reservation.service;

import dev.t1dmlgus.moviemvp.reservation.common.exception.EntityNotFoundException;
import dev.t1dmlgus.moviemvp.reservation.common.exception.ErrorType;
import dev.t1dmlgus.moviemvp.reservation.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


/**
 *
 * class : 영화관 서비스
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        영화관 생성 서비스
 * 2022-07-26           이의현        상영시간표 초기화 서비스
 * 2022-07-26           이의현        예매(상영) 서비스
 *
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CinemaService {

    @PersistenceContext
    EntityManager em;

    private final TheaterRepository theaterRepository;
    private final ScreenRepository screenRepository;
    private final ReservationRepository reservationRepository;


    @Transactional
    public CinemaInfo<Movie> todayScreenInit(ScreenSchedule screenSchedule) {

        // 영화관 별 상영표 등록
        Cinema cinema = Cinema.cinemaInstances.get(screenSchedule.getCinemaName());
        if (cinema==null)
            throw new EntityNotFoundException(ErrorType.CINEMA_ENTITY_NOT_FOUND);
        List<Screen> screenList = cinema.todayScreenInit(screenSchedule);

        screenRepository.saveAll(screenList);
        return new CinemaInfo<>(cinema.getCinemaName(), cinema.getShowingMovieFromMovie());
    }

    // 영화(상영) 예매하기
    @Transactional
    public ReservationInfo reservation(int audience, ReserveDto.ScreenReq screenReq) {

        Screen screen = screenReq.getScreenFromCinema();
        Screen mergeScreen = em.merge(screen);

        Reservation reservation = mergeScreen.reservation(audience);
        Reservation reservedScreen = reservationRepository.save(reservation);
        return ReservationInfo.from(reservedScreen);
    }


    // 영화관 별 상영조회   -> 화면으로 보여주고
    @Transactional
    public Screen screenByTheater(String theaterName) {
        Cinema cinema = Cinema.cinemaInstances.get(theaterName);
        List<Screen> screens = cinema.getScreens();
        return screens.get(2);
    }


    @Transactional
    public Reservation checkReservationOfMovie(){

        Long reservationMovie = 1L;

        Reservation reservation = reservationRepository.findById(reservationMovie)
                .orElseThrow(RuntimeException::new);

        System.out.println("reservation = " + reservation);
        return reservation;
    }



    public CinemaInfo<Theater> createCinema(CinemaDto.RegisterCinemaRequest request) {

        Cinema cinema = request.toCinemaEntity();
        Cinema savedCinema = theaterRepository.save(cinema);

        return new CinemaInfo<>(savedCinema.getCinemaName(), cinema.getTheaters());
    }
}