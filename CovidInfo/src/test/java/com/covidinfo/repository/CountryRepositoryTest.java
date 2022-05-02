package com.covidinfo.repository;

import com.covidinfo.entity.Country;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

@DataJpaTest
public class CountryRepositoryTest {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findCountryByNameTest(){
        Country c1 = new Country("c1", "3", "631263", "1000", "1500000", "0", "37121", "231231");
        testEntityManager.persistAndFlush(c1);

        Country foundC1 = countryRepository.findByName(c1.getName());
        assertThat(foundC1).isEqualTo(c1);
    }

    @Test
    void findAllCountriesTest(){
        Country c1 = new Country("c1", "3", "631263", "1000", "1500000", "0", "37121", "231231");
        Country c2 = new Country("c2", "3", "631263", "1000", "1500000", "0", "37121", "231231");
        Country c3 = new Country("c3", "3", "631263", "1000", "1500000", "0", "37121", "231231");

        testEntityManager.persist(c1);
        testEntityManager.persist(c2);
        testEntityManager.persist(c3);
        testEntityManager.flush();

        ArrayList<Country> countries = countryRepository.findAll();

        assertThat(countries).hasSize(3).extracting(Country::getName).containsOnly(c1.getName(), c2.getName(), c3.getName());
    }
}
