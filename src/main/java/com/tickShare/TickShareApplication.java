package com.tickShare;

import com.tickShare.entities.Trip;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.tickShare.repositories.TripRepository;


import java.util.Date;

@SpringBootApplication

public class TickShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(TickShareApplication.class, args);
	}
	@Bean
	CommandLineRunner initialize(TripRepository tripRepository) {
		return args -> {
				Trip trip = new Trip("Test","test", new Date(System.currentTimeMillis()).toString(),4,"Token");
				tripRepository.save(trip);
				tripRepository.findAll().forEach(System.out::println);
		};
	}
}
