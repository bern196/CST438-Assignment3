package CST438W3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import cst438hw3.domain.City;
import cst438hw3.domain.CityRepository;
import cst438hw3.domain.Country;
import cst438hw3.domain.CountryRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@ComponentScan({"cst438hw3.controller", "cst438hw3.service", "cst438hw3.domain"})
public class Cst438Assignment3Application {

	public static void main(String[] args) {
		SpringApplication.run(Cst438Assignment3Application.class, args);
	}

}
