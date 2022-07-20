package dev.t1dmlgus.moviemvp;

import dev.t1dmlgus.moviemvp.reservation.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
