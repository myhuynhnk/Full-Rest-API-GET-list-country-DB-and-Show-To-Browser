package com.devcamp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcamp.api.model.Country;

public interface ICountryRepository extends JpaRepository<Country, Integer> {
	Country findByCountryCode(String countryCode);
}
