package cst438hw3.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cst438hw3.domain.CityInfo;
import cst438hw3.domain.TempAndTime;
import cst438hw3.service.CityService;
import cst438hw3.service.WeatherService;

@RestController
@RequestMapping("/")
public class CityRestController {
	
	@Autowired
	private CityService cityService;

	@GetMapping("api/cities/{city}")
	public CityInfo getWeather(@PathVariable("city") String cityName, 
                               Model model) {
		
		CityInfo cityInfo = cityService.getCityInfo(cityName);
	    
		return cityInfo;
     }
}