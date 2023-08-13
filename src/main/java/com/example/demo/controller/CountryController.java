package com.example.demo.controller;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("get-country")
    public ResponseEntity<List<Country>> getCountry() {
        List<Country> countryList = countryRepository.findAll();
        return ResponseEntity.ok(countryList);
    }

    @GetMapping("/get-country/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable("id") String CountryId) {
        Optional<Country> countryData =
                countryRepository.findById(CountryId);
        if (countryData.isPresent()) {
            return new ResponseEntity<>(countryData.get(),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/get-country")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        try {
            Country _country = countryRepository
                    .save(new Country(country.getCountryId(),
                            country.getCountryName(), country.getRegionId()));
            return new ResponseEntity<>(_country, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null,
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/get-country/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable("id") String CountryId, @RequestBody Country country) {
        Optional<Country> countryData =
                countryRepository.findById(CountryId);
        if (countryData.isPresent()) {
            Country _country = countryData.get();
            _country.setCountryId(country.getCountryId());
            _country.setCountryName(country.getCountryName());
            _country.setRegionId(country.getRegionId());
            return new
                    ResponseEntity<>(countryRepository.save(_country), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/get-country/{id}")
    public ResponseEntity<HttpStatus> deleteCountry(@PathVariable("id") String CountryId) {
        try {
            countryRepository.deleteById(CountryId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new
                    ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/get-country")
    public ResponseEntity<HttpStatus> deleteAllCountries() {
        try {
            countryRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new
                    ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
