package cst438hw3.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Bean;

@Repository

public interface CityRepository extends JpaRepository<City, Long> {
	List<City> findByName(String name);
}