package sda.forum.api.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"sda.forum.api.article"})
@EntityScan("sda.forum.api.article")
@EnableJpaRepositories("sda.forum.api.article")
public class FirstprjApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprjApplication.class, args);
	}

}
