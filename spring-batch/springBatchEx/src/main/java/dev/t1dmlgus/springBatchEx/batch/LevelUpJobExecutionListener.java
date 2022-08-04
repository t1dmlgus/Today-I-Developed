package dev.t1dmlgus.springBatchEx.batch;

import dev.t1dmlgus.springBatchEx.domain.User;
import dev.t1dmlgus.springBatchEx.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class LevelUpJobExecutionListener implements JobExecutionListener {

    private final UserRepository userRepository;

    @Override
    public void beforeJob(JobExecution jobExecution) {}

    @Override
    public void afterJob(JobExecution jobExecution) {

        // 1. 등급 상향처리 된 유저 건수
        // 2. job 처리 시간

        Collection<User> users =
                userRepository.findAllByUpdateDate(LocalDate.now());

        long time = Objects.requireNonNull(jobExecution.getEndTime()).getTime()
                    - Objects.requireNonNull(jobExecution.getStartTime()).getTime();

        log.info("회원 등급 업데이트 배치 프로그램");
        log.info("------------------------");
        log.info("총 데이터 처리 {}건, 처리시간 {}mllis,", users.size(), time);
    }
}
