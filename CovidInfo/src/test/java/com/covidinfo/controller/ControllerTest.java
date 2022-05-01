package com.covidinfo.controller;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

import com.covidinfo.entity.Country;
import com.covidinfo.service.CovidService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class ControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CovidService covidService;

    @Test
    public void testCarCreate() throws IOException, Exception {
        ArrayList<Country> countries = new ArrayList<>();
        Country c1 = new Country("CountryTest", "3", "631263", "1000", "1500000", "0", "37121", "231231");
        Country c2 = new Country("CountryTest", "3", "631263", "1000", "1500000", "0", "37121", "231231");
        
        countries.add(c1);
        countries.add(c2);
    }
}
