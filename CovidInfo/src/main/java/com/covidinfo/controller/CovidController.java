package com.covidinfo.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import com.covidinfo.entity.Country;
import com.covidinfo.service.CovidService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CovidController {
    
    @GetMapping("/")
    @ResponseBody
    public String getData() throws IOException, InterruptedException {
        return CovidService.getCovidData();
    }

    @GetMapping("/countries")
    @ResponseBody
    public ArrayList<String> getCountries() throws IOException, InterruptedException {
        return CovidService.getCountries();
    }

    @GetMapping("/countries/data")
    @ResponseBody
    public ArrayList<Country> getTestsByCountries() throws IOException, InterruptedException {
        return CovidService.getCountriesData();
    }

    @GetMapping("/countries/{name}")
    public ArrayList<Country> getCityByName(@PathVariable(value = "name") String name) throws IOException, URISyntaxException, InterruptedException {
        return CovidService.getCountryByName(name);
    }
}
