package com.covidinfo.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import com.covidinfo.entity.Country;
import com.covidinfo.service.CovidService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@RestController
@RequestMapping("/api/v1")
public class CovidController {
    private static Logger logger = LogManager.getLogger(CovidController.class);

    @Autowired
    public CovidService covidService;
    
    @GetMapping("/")
    @ResponseBody
    public String getData() throws IOException, InterruptedException {
        logger.info("Getting all data from API");
        return this.covidService.getCovidData();
    }

    @GetMapping("/countries")
    @ResponseBody
    public ArrayList<String> getCountries() throws IOException, InterruptedException {
        logger.info("Getting all countries from API");
        return this.covidService.getCountries();
    }

    @GetMapping("/countries/data")
    @ResponseBody
    public ArrayList<Country> getTestsByCountries() throws IOException, InterruptedException {
        logger.info("Getting all data about countries from API");
        return this.covidService.getCountriesData();
    }

    @GetMapping("/countries/{name}")
    public Country getCityByName(@PathVariable(value = "name") String name) throws IOException, URISyntaxException, InterruptedException {
        logger.info("Getting data about {} from API", name);
        return this.covidService.getCountryByName(name);
    }

    @GetMapping("/cache")
    public HashMap<String, Integer> getCacheDetails() {
        logger.info("Getting cache details");
        return this.covidService.getCacheDetails();
    }
}
