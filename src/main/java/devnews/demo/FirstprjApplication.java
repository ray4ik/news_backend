package devnews.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication @ComponentScan({"article"})
public class FirstprjApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstprjApplication.class, args);
	}

}
