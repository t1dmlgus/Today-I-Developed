package dev.t1dmlgus.moviemvp.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
/**
 *
 * class : 배치 스케줄러
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-08-16           이의현        일 별 상영 시간표 업데이트 스케줄러 생성
 *
 */
@RequiredArgsConstructor
@Component
public class BatchScheduler {

    private final JobLauncher jobLauncher;
    private final BatchConfig batchConfig;


    @Scheduled(cron = "0 03 20 * * *")
    public void todayScreenUpdate(){

        HashMap<String, JobParameter> batchJob = new HashMap<>();
        batchJob.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(batchJob);

        try{
            jobLauncher.run(batchConfig.todayScreenJob(), jobParameters);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
