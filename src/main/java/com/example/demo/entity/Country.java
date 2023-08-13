package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRIES")
@Data
public class Country {

    @Id
    @Column(name = "COUNTRY_ID")
    private String CountryId;

    @Column(name = "COUNTRY_NAME")
    private String CountryName;

    @Column(name = "REGION_ID")
    private Integer RegionId;
    public Country() {
    }

    public Country(String countryId, String countryName, Integer regionId) {
        CountryId = countryId;
        CountryName = countryName;
        RegionId = regionId;
    }
    @Override
    public String toString() {
        return "COUNTRIES [COUNTRY_ID=" + CountryId + ", COUNTRY_NAME=" + CountryName + ", REGION_ID=" + RegionId + "]";
    }
}
