package dev.t1dmlgus.batch;

import dev.t1dmlgus.moviemvp.domain.cinema.CinemaRepository;
import dev.t1dmlgus.moviemvp.domain.screen.Screen;
import dev.t1dmlgus.moviemvp.service.cinema.ScreenDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class MovieConfiguration {


    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CinemaRepository cinemaRepository;

    @Bean
    public Job todayScreenJob() throws Exception {

        log.info("job >>> ");
        return this.jobBuilderFactory.get("todayScreenJob")
                .incrementer(new RunIdIncrementer())
                .start(this.screenInitStep())
                .build();
    }

    @Bean
    public Step screenInitStep() throws Exception {

        log.info("step >>> ");
        return this.stepBuilderFactory.get("screenInit")
                .<ScreenDto, Screen> chunk(30)
                .reader(csvFileItemReader())
                //.processor(itemProcessor())
                .writer(itemWriter())
                .build();



    }

    private ItemWriter<? super Screen> itemWriter() {
        return items -> items.forEach(x-> log.info(x.toString()));
    }


    private FlatFileItemReader<ScreenDto> csvFileItemReader() throws Exception {

        // 데이터를 1줄씩 읽을 수 있는 설정
        DefaultLineMapper<ScreenDto> lineMapper = new DefaultLineMapper<>();
        // csv 파일 -> Screen으로 매핑하기 위해 Screen 필드명을 설정하는 tokenizer 객체 생성
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setNames("date","cinemaName","movieTitle","theaterName","startTime");
        lineMapper.setLineTokenizer(lineTokenizer);


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

}
