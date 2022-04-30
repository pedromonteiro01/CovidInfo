package com.covidinfo.controller;

import com.covidinfo.entity.Country;
import com.covidinfo.service.CovidService;
import com.github.dockerjava.core.MediaType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;
import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(RestController.class)
public class ControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CovidService covidService;

    /*
            this.name = name;
        this.newCases = newCases;
        this.activeCases = activeCases;
        this.recoveredCases = recoveredCases;
        this.totalCases = totalCases;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
        this.totalTests = totalTests;
    */
    
}
