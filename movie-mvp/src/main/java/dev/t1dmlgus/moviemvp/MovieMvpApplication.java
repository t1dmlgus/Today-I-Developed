package dev.t1dmlgus.moviemvp;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class MovieMvpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieMvpApplication.class, args);
	}
}
