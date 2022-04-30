package com.covidinfo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import com.covidinfo.entity.Country;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServiceTest {
    @DisplayName("Test getCountryByName()")
    @Test
    void testGetCountryByNameWhenCountryNotExists() throws IOException, InterruptedException {
        ArrayList<Country> emptyArray = new ArrayList<>();
        // when looking for country 'x' must returns an empty array
        assertEquals(emptyArray, CovidService.getCountryByName("x"));
    }
}
