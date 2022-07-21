package dev.t1dmlgus.moviemvp.service;

import dev.t1dmlgus.moviemvp.reservation.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;

    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;

    private final ReservationRepository reservationRepository;

    @Transactional
    public void todayScreen() {
        ScreenDtos screenDtos =
                new ScreenDtos("20220721","안양",
                        List.of(new ScreenDtos.MovieDto("미니언즈2",
                                List.of(new ScreenDtos.CinemaDetail("7관","0935"),
                                        new ScreenDtos.CinemaDetail("4관","1030"),
                                        new ScreenDtos.CinemaDetail("6관","1155"),
                                        new ScreenDtos.CinemaDetail("4관","1450"),
                                        new ScreenDtos.CinemaDetail("6관","1545")
                                        )
                                ),
                                new ScreenDtos.MovieDto("외계+인 1부",
                                        List.of(new ScreenDtos.CinemaDetail("5관","1050"),
                                                new ScreenDtos.CinemaDetail("7관","1130"),
                                                new ScreenDtos.CinemaDetail("1관","1215"),
                                                new ScreenDtos.CinemaDetail("3관","1300"),
                                                new ScreenDtos.CinemaDetail("5관","1340")
                                        )
                                )
                        )
                );


        // 영화관 별 | 영화 별

        List<Movie> movieOnScreen = movieRepository.findAll();

        // 영화관 별 상영표 등록
        Theater theater = Theater.theaterInstance.get(screenDtos.getTheaterName());
        List<Screen> screens = theater.todayScreen(screenDtos, movieOnScreen);

        // 등록 내용 조회
        List<Screen> screens1 = screenRepository.saveAll(screens);
        for (Screen screen : screens1) {
            System.out.println("screen = " + screen);
        }

    }

    @Transactional
    public void reservation(int audience, Screen screen) {

        Reservation reservation = screen.reservation(audience);

        Reservation save = reservationRepository.save(reservation);
        System.out.println("save 예약성공! > = " + save);
    }


    // 영화관 별 상영조회   -> 화면으로 보여주고
    @Transactional
    public Screen screenByTheater(String theaterName) {
        Theater theater = Theater.theaterInstance.get(theaterName);
        List<Screen> screens = theater.getScreens();
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


    // 상영시간표
    @Transactional
    public void createScreenByTheater(){

        // 영화관 별 상영시간표 생성

       /** # 미니언즈
        * 1(안양) / 3(영화) / 7(상영관) / 09:35(시작시간)
        * 1(안양) / 3(영화) / 4(상영관) / 10:30(시작시간)
        * 1(안양) / 3(영화) / 6(상영관) / 11:55(시작시간)
        * 1(안양) / 3(영화) / 6(상영관) / 15:45(시작시간)
        * 1(안양) / 3(영화) / 4(상영관) / 14:50(시작시간)
        *
        **/


        // 영화관(안양)
        Long theaterNo = 1L;

        // 영화관 생성
        Theater theater = theaterRepository.findById(theaterNo)
                .orElseThrow(() -> new RuntimeException("해당 영화관은 없습니다."));

        // 상영관
        List<Cinema> cinemas = theater.getCinemas();


        // 영화(미니언즈)
        Long movieNo = 3L;
        Movie movie = movieRepository.findById(movieNo)
                .orElseThrow(() -> new RuntimeException("해당 영화는 상영하지 않습니다."));

        // 상영시간표

        /** 배치 또는 nosql
         *
         * # 미니언즈
         * 1(안양) / 3(영화) / 7(상영관) / 09:35(시작시간)
         * 1(안양) / 3(영화) / 4(상영관) / 10:30(시작시간)
         * 1(안양) / 3(영화) / 6(상영관) / 11:55(시작시간)
         * 1(안양) / 3(영화) / 4(상영관) / 14:50(시작시간)
         * 1(안양) / 3(영화) / 6(상영관) / 15:45(시작시간)
         *
         * dto : ScreenDto
         *
         * # 토르: 러브 앤 썬더
         * 1(안양) / 1(영화) / 4(상영관) / 12:25(시작시간)
         * 1(안양) / 1(영화) / 4(상영관) / 20:35(시작시간)
         *
         *
         */

        List<ScreenDtos> screenDtos = new ArrayList<>();

        LocalDateTime of1 = LocalDateTime.of(2022, 7, 20, 9, 35);
        LocalDateTime of2 = LocalDateTime.of(2022, 7, 20, 10, 30);
        LocalDateTime of3 = LocalDateTime.of(2022, 7, 20, 11, 55);
        LocalDateTime of4 = LocalDateTime.of(2022, 7, 20, 14, 50);
        LocalDateTime of5 = LocalDateTime.of(2022, 7, 20, 15, 45);

        int cinemaNo = 7;



        List<Screen> screens = new ArrayList<>();

//        screens.add(Screen.todayScreenInitByTheater(theater, movie, 7, of1));
//        screens.add(Screen.todayScreenInitByTheater(theater, movie, 4, of2));
//        screens.add(Screen.todayScreenInitByTheater(theater, movie, 6, of3));
//        screens.add(Screen.todayScreenInitByTheater(theater, movie, 4, of4));
//        screens.add(Screen.todayScreenInitByTheater(theater, movie, 6, of5));
        screenRepository.saveAll(screens);


        Theater.todayScreenList.addAll(screens);

    }

    public void createTheater(){

        List<Cinema> cinemas = new ArrayList<>();
        cinemas.add(Cinema.newInstance("1관", 228));
        cinemas.add(Cinema.newInstance("2관", 153));
        cinemas.add(Cinema.newInstance("3관", 129));
        cinemas.add(Cinema.newInstance("4관", 96));
        cinemas.add(Cinema.newInstance("5관", 129));
        cinemas.add(Cinema.newInstance("6관", 153));
        cinemas.add(Cinema.newInstance("7관", 228));

        Theater theater = Theater.newInstance("안양", cinemas);
        Theater save = theaterRepository.save(theater);


        /**
         *  상영관 생성도 따로 -> 설계할 것!
         *
         *
         */


//        cinemas.add(Cinema.newInstance("1관", 312));
//        cinemas.add(Cinema.newInstance("2관", 72));
//        cinemas.add(Cinema.newInstance("3관", 232));
//
//        Theater theater2 = Theater.newInstance("범계", cwwinemas);
//        Theater save2 = theaterRepository.save(theater2);

    }


    // 영화관 - 상영관 생성

    // 영화 생성

    // 상영 - 영화 등록







}
