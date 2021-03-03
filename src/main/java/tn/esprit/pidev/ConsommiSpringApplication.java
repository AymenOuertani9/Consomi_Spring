package tn.esprit.pidev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import tn.esprit.pidev.repositories.UserRepository;
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@ComponentScan
@SpringBootApplication
public class ConsommiSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsommiSpringApplication.class, args);
	}

}
