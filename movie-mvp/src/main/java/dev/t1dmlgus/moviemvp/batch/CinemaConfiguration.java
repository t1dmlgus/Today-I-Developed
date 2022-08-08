package dev.t1dmlgus.moviemvp.batch;

import dev.t1dmlgus.moviemvp.domain.cinema.Cinema;
import dev.t1dmlgus.moviemvp.domain.movie.Movie;
import dev.t1dmlgus.moviemvp.domain.screen.Screen;
import dev.t1dmlgus.moviemvp.domain.theater.Theater;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaCursorItemReader;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaCursorItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class CinemaConfiguration {


    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;

    @Bean
    public Job todayScreenJob() throws Exception {

        log.info("Screen job >>> ");
        return this.jobBuilderFactory.get("initTodayScreenTime")
                .incrementer(new RunIdIncrementer())
                .start(this.screenMovieStep())
                .next(this.cinemaStep())
                .next(this.screenInitStep())
                .build();
    }


    @Bean
    public Step screenMovieStep() throws Exception {

        log.info("screenMovieStep >> ");

        return stepBuilderFactory.get("screenMovieStep")
                .<Movie, Movie>chunk(10)
                .reader(this.jpaCursorItemReader())
                .writer(itemWriter2())
                .build();
    }

    private JpaCursorItemReader<Movie> jpaCursorItemReader() throws Exception {

        JpaCursorItemReader<Movie> itemReader = new JpaCursorItemReaderBuilder<Movie>()
                .name("jpaCursorItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select m from Movie m where m.status = 'SHOWING'")
                .build();

        itemReader.afterPropertiesSet();
        return itemReader;
    }

    private ItemWriter<? super Movie> itemWriter2() {
        return items -> {
            Movie.showingMovie.addAll(items);
        };
    }


    @Bean
    public Step cinemaStep() throws Exception {

        log.info("cinemaStep >> ");

        return stepBuilderFactory.get("cinemaStep")
                .<Cinema, Cinema>chunk(50)
                .reader(this.cinemaJpaCursorItemReader())
                .processor(this.cinemaProcess())
                .writer(cinemaItemWriter())
                .build();
    }

    private JpaCursorItemReader<Cinema> cinemaJpaCursorItemReader() throws Exception {

        JpaCursorItemReader<Cinema> itemReader = new JpaCursorItemReaderBuilder<Cinema>()
                .name("jpaCursorItemReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("select c from Cinema c ")
                .build();

        itemReader.afterPropertiesSet();
        return itemReader;
    }


    private ItemProcessor<? super Cinema, ? extends Cinema> cinemaProcess() {

        return cinema -> {
            List<Theater> theaters = cinema.getTheaters();
            log.info(String.valueOf(theaters));
            return cinema;
        };
    }


    private ItemWriter<? super Cinema> cinemaItemWriter() {

        return items -> {
            items.forEach(x -> Cinema.cinemaInstances.put(x.getCinemaName(), x));
        };
    }





    @Bean
    public Step screenInitStep() throws Exception {

        log.info("Screen step >>> ");
        return this.stepBuilderFactory.get("screenInit")
                .<ScreenDto, Screen> chunk(10)
                .reader(csvFileItemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();

    }


    private FlatFileItemReader<ScreenDto> csvFileItemReader() throws Exception {

        // 데이터를 1줄씩 읽을 수 있는 설정
        DefaultLineMapper<ScreenDto> lineMapper = new DefaultLineMapper<>();
        // csv 파일 -> Screen으로 매핑하기 위해 Screen 필드명을 설정하는 tokenizer 객체 생성
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setNames("date","cinemaName","movieTitle","theaterName","startTime");
        lineMapper.setLineTokenizer(lineTokenizer);

        lineMapper.setFieldSetMapper(fieldSet -> {

            String date = fieldSet.readString("date");
            String cinemaName = fieldSet.readString("cinemaName");
            String movieTitle = fieldSet.readString("movieTitle");
            String theaterName = fieldSet.readString("theaterName");
            String startTime = fieldSet.readString("startTime");

            return new ScreenDto(date, cinemaName, movieTitle, theaterName, startTime);
        });

        // flatFileItemReaderBuilder
        FlatFileItemReader<ScreenDto> itemReader = new FlatFileItemReaderBuilder<ScreenDto>()
                .name("csvFileItemReader")
                .encoding("UTF-8")
                .linesToSkip(1)
                .resource(new ClassPathResource("screen.csv"))
                .lineMapper(lineMapper)
                .build();

        itemReader.afterPropertiesSet();
        return itemReader;
    }



    private ItemProcessor<? super ScreenDto,? extends Screen> itemProcessor() {

        return item -> {
            Cinema cinema = Cinema.cinemaInstances.get(item.getCinemaName());
            return item.toScreenEntity();
        };
    }

    private ItemWriter<? super Screen> itemWriter() throws Exception {

        JpaItemWriter<Object> itemWriter = new JpaItemWriterBuilder<>()
                .entityManagerFactory(entityManagerFactory)
                .usePersist(true)
                .build();

        itemWriter.afterPropertiesSet();
        return itemWriter;
    }
}
