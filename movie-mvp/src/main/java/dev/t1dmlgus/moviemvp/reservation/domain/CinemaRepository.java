package dev.t1dmlgus.moviemvp.reservation.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
//    Optional<List<Cinema>> find(Long theaterId);
}
