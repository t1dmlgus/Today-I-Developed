package dev.t1dmlgus.springBatchEx.batch;

import dev.t1dmlgus.springBatchEx.domain.Orders;
import dev.t1dmlgus.springBatchEx.domain.User;
import dev.t1dmlgus.springBatchEx.domain.UserRepository;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SaveUserTasklet implements Tasklet {

    private final int SIZE = 100;
    private final UserRepository userRepository;

    public SaveUserTasklet(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

        List<User> users = createUser();
        Collections.shuffle(users);

        userRepository.saveAll(users);
        return null;
    }

    private List<User> createUser() {
        ArrayList<User> users = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            users.add(User.builder()
                    .username("test username" + i)
                    .orders(Collections.singletonList(Orders.builder()
                            .amount(1_000)
                            .createDate(LocalDate.of(2021,8,1))
                            .itemName("item"+i)
                            .build())
                    )
                    .build());
        }

        for (int i = 0; i < SIZE; i++) {
            users.add(User.builder()
                    .username("test username" + i)
                    .orders(Collections.singletonList(Orders.builder()
                            .amount(200_000)
                            .createDate(LocalDate.of(2021,8,2))
                            .itemName("item"+i)
                            .build())
                    )
                    .build());
        }

        for (int i = 0; i < SIZE; i++) {
            users.add(User.builder()
                    .username("test username" + i)
                    .orders(Collections.singletonList(Orders.builder()
                            .amount(300_000)
                            .createDate(LocalDate.of(2021,8,3))
                            .itemName("item"+i)
                            .build())
                    ).build());
        }

        for (int i = 0; i < SIZE; i++) {
            users.add(User.builder()
                    .username("test username" + i)
                    .orders(Collections.singletonList(Orders.builder()
                            .amount(500_000)
                            .createDate(LocalDate.of(2022,8,4))
                            .itemName("item"+i)
                            .build())
                    )
                    .build());
        }


        return users;
    }
}
