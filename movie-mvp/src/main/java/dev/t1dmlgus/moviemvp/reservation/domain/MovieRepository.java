package dev.t1dmlgus.moviemvp.reservation.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    boolean existsByTitle(String movieTitle);
}
