package cst438hw3.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cst438hw3.domain.City;
import cst438hw3.domain.CityInfo;
import cst438hw3.domain.CityRepository;
import cst438hw3.domain.Country;
import cst438hw3.domain.CountryRepository;
import cst438hw3.domain.TempAndTime;
import cst438hw3.service.CityService;
import cst438hw3.service.WeatherService;

@RestController
@RequestMapping("/")

//@PostMapping("/cities/reservation")

//public String createReservation(
		
//	@RequestParam("city") String cityName, 
//	@RequestParam("level") String level, 
	//@RequestParam("email") String email, 
	
//	Model model) {
	
	//model.addAttribute("city", cityName);
	////model.addAttribute("level", level);
//	model.addAttribute("email", email);
	//cityService.requestReservation(cityName, level, email);
//	return "request_reservation";
//}

public class CityController {
	
	@Autowired
	CityRepository cityRepository;
	
	
	@GetMapping("/cities/{city}")
	public String getCityInfo(@PathVariable("city") String cityName, 
                               Model model) {
		
	
		List<City> cities = cityRepository.findByName(cityName);
		
		TempAndTime tempAndTime = new TempAndTime(100, 123511, 0);
		
		String content = "<div> <h1>City</h1>";
		
		content += "<table>";
		
		for (City city: cities) {
			
			content += "<tr>";
			content += "<td>ID</td>";
			content += "<td>" + city.getId();		
			content += "</td>";
			content += "</tr>";
			
			content += "<tr>";
			content += "<td>Name</td>";
			content += "<td>" + city.getName();	
			content += "</td>";
			content += "</tr>";
			
			content += "<tr>";
			content += "<td>Country Code</td>";
			content += "<td>" + city.getCountry().getCode();
			content += "</td>";
			content += "</tr>";
			
			content += "<tr>";
			content += "<td>Country Name</td>";
			content += "<td>"+ city.getCountry().getName();
			content += "</td>";
			content += "</tr>";
			
			content += "<tr>";
			content += "<td>District</td>";
			content += "<td>" + city.getDistrict();	
			content += "</td>";
			content += "</tr>";
			
			content += "<tr>";
			content += "<td>Population</td>";
			content += "<td>" + city.getPopulation();
			content += "</td>";			
			content += "</tr>";
		}
		
		content += "<tr>";
		content += "<td></td>";
		content += "<td></td>";
		content += "</td>";			
		content += "</tr>";
		
		
		//format time
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");		
		
		//to Fahrenheit
		double toFahrenheit = (tempAndTime.temp - 273.15) * 9.0 / 5.0 + 32.0;
		
		content += "<tr>";
		content += "<td>Local Weather</td>";
		content += "<td>" + toFahrenheit;	
		content += "</td>";
		content += "</tr>";
		
		content += "<tr>";
		content += "<td>Local Time</td>";
		content += "<td>" + sdf.format(new Date(tempAndTime.time)); 	
		content += "</td>";
		content += "</tr>";
		
		
		content += "</table>";	
		
		
		content += "</div>";
	    
		return content;
     }
}
