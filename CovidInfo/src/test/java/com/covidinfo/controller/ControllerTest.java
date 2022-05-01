package com.covidinfo.controller;

import static org.mockito.Mockito.when;

import com.covidinfo.entity.Country;
import com.covidinfo.service.CovidService;

import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(CovidController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CovidService covidService;

    @Test
    public void getCountryByNameTest() throws Exception {
        Country c1 = new Country("c1");
        when(this.covidService.getCountryByName("c1")).thenReturn(c1);
        mvc.perform(get("/api/v1/countries/{country}", "c1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$.name", is("c1")));;
    }

    @Test
    void getAllCountriesTest() throws Exception {
        Country c1 = new Country("c1");
        Country c2 = new Country("c2");
        ArrayList<String> countries = new ArrayList<>();
        countries.add(c1.getName());
        countries.add(c2.getName());

        when(this.covidService.getCountries()).thenReturn(countries);
        mvc.perform(get("/api/v1/countries").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0]", is("c1"))).andExpect(jsonPath("$[1]", is("c2")));

    }

    @Test
    void getCacheDetailsTest() throws Exception {
        HashMap<String, Integer> cacheMap = new HashMap<>();
        cacheMap.put("hits", 2);
        cacheMap.put("misses", 3);
        cacheMap.put("requests", 5);

        given(covidService.getCacheDetails()).willReturn(cacheMap);
        mvc.perform(get("/api/v1/cache").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.hits", is(2)))
                .andExpect(jsonPath("$.misses", is(3)))
                .andExpect(jsonPath("$.requests", is(5)));

    }
}
