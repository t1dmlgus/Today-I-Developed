package dev.t1dmlgus.moviemvp.reservation.service;

import dev.t1dmlgus.moviemvp.reservation.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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
        List<Screen> screenList = cinema.todayScreenInit(screenSchedule);

        screenRepository.saveAll(screenList);
        return new CinemaInfo<>(cinema.getCinemaName(), cinema.getShowingMovieFromMovie());
    }

    // 영화(상영) 예매하기
    @Transactional
    public ReservationInfo reservation(int audience, ScreenToReserveCommand screenToReserveCommand) {

        Screen screen = screenToReserveCommand.getScreenFromCinema();
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



    public CinemaInfo<Theater> createCinema(CinemaToRegisterCommand cinemaToRegisterCommand) {

        Cinema cinema = cinemaToRegisterCommand.toEntity();
        Cinema savedCinema = theaterRepository.save(cinema);

        return new CinemaInfo<>(savedCinema.getCinemaName(), cinema.getTheaters());
    }
}
