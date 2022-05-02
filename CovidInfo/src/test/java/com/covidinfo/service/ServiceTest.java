package com.covidinfo.service;

import java.io.IOException;

import com.covidinfo.Cache.Cache;
import com.covidinfo.entity.Country;
import com.covidinfo.repository.CountryRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock(lenient=true)
    private CountryRepository countryRepository;

    @Mock
    private Cache cache;

    @BeforeEach
    void setUp() throws IOException, InterruptedException {
        cache = new Cache();
        Country c1 = new Country("c1", "3", "631263", "1000", "1500000", "0", "37121", "231231");
        Country c2 = new Country("c2", "23", "423423", "123", "12414144", "0", "37121", "231231");
        cache.addToCache("c1", c1);
        cache.addToCache("c2", c2);
    
        when(countryRepository.findByName(c1.getName())).thenReturn(c1);
        when(countryRepository.findByName(c2.getName())).thenReturn(c2);
    }

    @AfterEach
    void tearDown(){
    }

    @Test
    void getCountryTest() throws IOException, InterruptedException {
        String countryName = "c1";
        int newCases = Integer.parseInt("3");
        int newDeaths = Integer.parseInt("0");
        Country foundC1 = cache.getCountryFromCache("c1");
        assertThat(foundC1.getName()).isEqualTo(countryName);
        assertThat(Integer.parseInt(foundC1.getNewCases())).isEqualTo(newCases);
        assertThat(Integer.parseInt(foundC1.getNewDeaths())).isEqualTo(newDeaths);
    }

    @Test
    void getInvalidCountryTest() throws IOException, InterruptedException {
        Country foundC1 = cache.getCountryFromCache("abc");
        assertThat(foundC1).isEqualTo(null);
    }
}