package com.covidinfo.service;

import java.io.IOException;
import java.util.ArrayList;

import com.covidinfo.entity.Country;
import com.covidinfo.repository.CountryRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock(lenient=true)
    private CountryRepository countryRepository;

    @InjectMocks
    private CovidService covidService;

    @BeforeEach
    void setUp() throws IOException, InterruptedException {
        this.covidService = new CovidService();
        Country c1 = new Country("c1", "3", "631263", "1000", "1500000", "0", "37121", "231231");
        Country c2 = new Country("c2", "23", "423423", "123", "12414144", "0", "37121", "231231");

        ArrayList<Country> countries = new ArrayList<>();
        countries.add(c1);
        countries.add(c2);

        when(countryRepository.findByName(c1.getName())).thenReturn(c1);
        when(countryRepository.findByName(c2.getName())).thenReturn(c2);
        when(countryRepository.findAll()).thenReturn(countries);
    }

    @AfterEach
    void tearDown(){
    }

    @Test
    void countryTest() throws IOException, InterruptedException {
        String countryName = "c1";
        Country foundC1 = covidService.getCountryByName("c1");
        assertThat(foundC1.getName()).isEqualTo(countryName);
        assertThat(foundC1.getNewCases()).isEqualTo("3");
    }
}
