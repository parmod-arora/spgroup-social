package com.spgroup.social;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spgroup.social.dao.UserRepository;
import com.spgroup.social.dao.domain.User;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Bean
	public CommandLineRunner loadData(UserRepository repository) {
	    return (args) -> {
	    	IntStream.rangeClosed(1, 20).forEach(num -> {
	    		repository.save(new User("test"+num+"@test.com"));
	    	});
	    };
	}

}
