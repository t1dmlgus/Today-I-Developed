package dev.t1dmlgus.moviemvp;

import dev.t1dmlgus.moviemvp.reservation.*;
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
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;


    // 상영시간표
    @Transactional
    public void createScreen(){

        // 영화관 별 상영시간표 생성

        // 영화관(안양)
        Long theaterNo = 1L;
        Theater theater = theaterRepository.findById(theaterNo)
                .orElseThrow(() -> new RuntimeException("해당 영화관은 없습니다."));

        // 상영관
        List<Cinema> cinemas = theater.getCinemas();
        Cinema cinema = cinemas.get(6);

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

        screens.add(Screen.todayScreenInitByTheater(theater, movie, 6, of1));
        screens.add(Screen.todayScreenInitByTheater(theater, movie, 3, of2));
        screens.add(Screen.todayScreenInitByTheater(theater, movie, 4, of3));
        screens.add(Screen.todayScreenInitByTheater(theater, movie, 3, of4));
        screens.add(Screen.todayScreenInitByTheater(theater, movie, 5, of5));
        screenRepository.saveAll(screens);


        Theater.todayScreenList.addAll(screens);

    }

    public void createTheater(){

        List<Cinema> cinemas = new ArrayList<>();
        cinemas.add(Cinema.newInstance("제1상영관", 228));
        cinemas.add(Cinema.newInstance("제2상영관", 153));
        cinemas.add(Cinema.newInstance("제3상영관", 129));
        cinemas.add(Cinema.newInstance("제4상영관", 96));
        cinemas.add(Cinema.newInstance("제5상영관", 129));
        cinemas.add(Cinema.newInstance("제6상영관", 153));
        cinemas.add(Cinema.newInstance("제7상영관", 228));

        Theater theater = Theater.newInstance("안양 롯데시네마", cinemas);
        Theater save = theaterRepository.save(theater);

        cinemas.clear();



        cinemas.add(Cinema.newInstance("제1상영관", 312));
        cinemas.add(Cinema.newInstance("제2상영관", 72));
        cinemas.add(Cinema.newInstance("제3상영관", 232));

        Theater theater2 = Theater.newInstance("범계 롯데시네마", cinemas);
        Theater save2 = theaterRepository.save(theater2);

    }





    public void getCinema(Long id){

    }


    // 영화관 - 상영관 생성

    // 영화 생성

    // 상영 - 영화 등록







}
