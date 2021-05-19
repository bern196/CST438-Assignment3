package cst438hw3.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cst438hw3.domain.*;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private WeatherService weatherService;
	
	public CityInfo getCityInfo(String cityName) {	
		
		
		TempAndTime tempAndTime = weatherService.getTempAndTime(cityName);		
		List<City> cities = cityRepository.findByName(cityName);		
		City city = null;
		
		CityInfo info = new CityInfo();
		
		if (cities.size() > 0 && tempAndTime != null)
		{
			city = cities.get(0);
			
			//format time
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");		
			
			//to Fahrenheit
			double toFahrenheit = (tempAndTime.temp - 273.15) * 9.0 / 5.0 + 32.0;
			
			info.setId(city.getId());
			info.setName(city.getName());
			info.setCountryCode(city.getCountry().getCode());
			info.setCountryName(city.getCountry().getName());
			info.setDistrict(city.getDistrict());
			info.setPopulation(city.getPopulation());
			
			info.setTemp(toFahrenheit);
			info.setTime(sdf.format(tempAndTime.time));
		}


		return info;
     }
}
