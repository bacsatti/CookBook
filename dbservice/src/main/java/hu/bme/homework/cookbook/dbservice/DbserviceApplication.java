package hu.bme.homework.cookbook.dbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("hu.bme.homework.cookbook.dbservice")
@EntityScan("hu.bme.homework.cookbook.dbservice")
@EnableJpaRepositories("hu.bme.homework.cookbook.dbservice")
public class DbserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbserviceApplication.class, args);
	}
}
