package dev.t1dmlgus.moviemvp;

import dev.t1dmlgus.moviemvp.reservation.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
//    Optional<List<Cinema>> find(Long theaterId);
}
