package com.covidinfo.service;

import java.io.IOException;
import java.util.ArrayList;

import com.covidinfo.entity.Country;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @InjectMocks
    private CovidService covidService;

    @BeforeEach
    void setUp() throws IOException, InterruptedException {
        this.covidService = new CovidService();
        Country c1 = new Country("c1");
        Country c2 = new Country("c2");

        ArrayList<Country> countries = new ArrayList<>();
        countries.add(c1);
        countries.add(c2);

        when(covidService.getCountryByName(c1.getName())).thenReturn(c1);
        when(covidService.getCountryByName(c2.getName())).thenReturn(c2);
    }

    /*@Test
    public void countryTest() throws IOException, InterruptedException {
        Country c1 = covidService.getCountryByName("c1");
        assertThat(c1.getName()).isEqualTo("c1");
    }*/
}
