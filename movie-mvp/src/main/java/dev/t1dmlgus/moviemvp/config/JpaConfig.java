package dev.t1dmlgus.moviemvp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * class : JPA 설정
 * version 1.0
 * ==========================================
 * DATE              DEVELOPER   NOTE
 * ==========================================
 * 2022-07-26        이의현        JPA Auditing
 *
 */
@EnableScheduling
@EnableJpaAuditing
@Configuration
public class JpaConfig {
}
