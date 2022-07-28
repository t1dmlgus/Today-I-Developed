package dev.t1dmlgus.moviemvp.domain.theater;

import dev.t1dmlgus.moviemvp.domain.cinema.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Cinema, Long> {
}
