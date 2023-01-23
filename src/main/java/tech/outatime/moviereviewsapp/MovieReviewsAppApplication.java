package tech.outatime.moviereviewsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MovieReviewsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewsAppApplication.class, args);
	}

	@GetMapping("/")
	public String apiRoot() {
		return "Hello from JAVA SpringBoot!";
	}
}
