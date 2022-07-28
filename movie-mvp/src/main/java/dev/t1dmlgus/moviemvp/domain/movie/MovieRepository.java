package dev.t1dmlgus.moviemvp.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 *
 * class : 영화 Domain
 * version 1.0
 * ==================================================
 * DATE                 DEVELOPER   NOTE
 * ==================================================
 * 2022-07-26           이의현        영화 존재유무 쿼리메서드(영화명)
 * 2022-07-27           이의현        영화 토큰 존재유무 쿼리메서드(영화토큰)
 *
 *
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

    boolean existsByTitle(String movieTitle);

    Optional<Movie> findByMovieToken(String movieToken);
}
