package dev.t1dmlgus.moviemvp.domain.cinema;

import dev.t1dmlgus.moviemvp.domain.theater.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 *
 * class : 영화관 Repository
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        JpaRepository
 *
 */
public interface CinemaRepository extends JpaRepository<Theater, Long> {

    Optional<Cinema> findByCinemaName(String cinemaName);
}
