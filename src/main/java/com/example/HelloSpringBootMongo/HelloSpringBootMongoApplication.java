package com.example.HelloSpringBootMongo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages="models")
public class HelloSpringBootMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootMongoApplication.class, args);
	}

}
