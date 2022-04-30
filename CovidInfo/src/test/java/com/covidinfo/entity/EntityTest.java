package com.covidinfo.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class EntityTest {
    Country country = new Country("CountryTest", "3", "631263", "1000", "1500000", "0", "37121", "231231");

    @Test
    void countryTest() {
        assertEquals("CountryTest", country.getName());
        assertEquals("3", country.getNewCases());
        assertEquals("631263", country.getActiveCases());
        assertEquals("1000", country.getRecoveredCases());
        assertEquals("1500000", country.getTotalCases());
        assertEquals("0", country.getNewDeaths());
        assertEquals("37121", country.getTotalDeaths());
        assertEquals("231231", country.getTotalTests());
    }

    @Test
    void invalidValuesCountryTest() {
        // all this values should 0 or bigger, can't be lower than 0
        assertThat(Integer.parseInt(country.getNewCases()), greaterThan(-1));
        assertThat(Integer.parseInt(country.getActiveCases()), greaterThan(-1));
        assertThat(Integer.parseInt(country.getRecoveredCases()), greaterThan(-1));
        assertThat(Integer.parseInt(country.getTotalCases()), greaterThan(-1));
        assertThat(Integer.parseInt(country.getNewDeaths()), greaterThan(-1));
        assertThat(Integer.parseInt(country.getTotalDeaths()), greaterThan(-1));
        assertThat(Integer.parseInt(country.getTotalTests()), greaterThan(-1));
    }

    @Test
    void checkCountriesCreation() {
        Country country1 = new Country("CountryTest1", "3", "631263", "1000", "1500000", "0", "312311", "231231");
        Country country2 = new Country("CountryTest2", "233", "84124", "123", "12986745", "2", "37121", "4214");
        Country country3 = new Country("CountryTest3", "187", "24141", "874", "75347345", "1", "56542", "12");

        ArrayList<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);

        assertThat(countries, hasSize(3));
    }
}
