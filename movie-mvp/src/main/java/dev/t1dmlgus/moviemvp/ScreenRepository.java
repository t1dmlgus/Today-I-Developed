package dev.t1dmlgus.moviemvp;

import dev.t1dmlgus.moviemvp.reservation.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
