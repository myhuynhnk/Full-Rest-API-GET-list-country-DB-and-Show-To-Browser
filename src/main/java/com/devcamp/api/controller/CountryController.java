package com.devcamp.api.controller;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devcamp.api.model.Country;
import com.devcamp.api.model.Region;
import com.devcamp.api.repository.ICountryRepository;

@RestController
public class CountryController {
	@Autowired
	ICountryRepository countryRepository;
	
	@CrossOrigin
	@GetMapping("/countries")
	public ResponseEntity<ArrayList<Country>> getAllCountry() {
		try {
			ArrayList<Country> listCountry = new ArrayList<>();
			countryRepository.findAll().forEach(listCountry::add);
			return new ResponseEntity<>(listCountry, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@GetMapping("/regions")
	public ResponseEntity<Set<Region>> getRegionByCountryCode(@RequestParam String countryCode) {
		try {
			Country country = countryRepository.findByCountryCode(countryCode);
			if(country != null) {
				return new ResponseEntity<>(country.getRegions(), HttpStatus.OK);
			}else {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
