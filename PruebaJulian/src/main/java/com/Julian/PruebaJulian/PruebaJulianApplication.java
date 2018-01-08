package com.Julian.PruebaJulian;

import com.Julian.PruebaJulian.Entities.PersonEntity;
import com.Julian.PruebaJulian.Repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PruebaJulianApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaJulianApplication.class, args);

	}

	@Bean
	CommandLineRunner runner(PersonRepository repository){
		return args->{
			repository.save(new PersonEntity("Donald", "Duck","1 Disneyland", "99999", "876-543-2104", "Golden"));
		};
	}



}
