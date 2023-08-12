package com.example.demo.controller;

import com.example.demo.entity.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
