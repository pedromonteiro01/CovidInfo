package com.covidinfo.Cache;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.covidinfo.entity.Country;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CacheTest {

    private Cache cache;

    @BeforeEach
    void setUp() {
        cache = new Cache();
    }

    @AfterEach
    void tearDown(){
        cache.clearCache();
    }
    
    @Test
    void addValueToCacheTest(){
        assertEquals(0, cache.getCacheSize());
        cache.addToCache("CountryTest", new Country("CountryTest"));
        assertEquals(1, this.cache.getCacheSize());
        assertEquals(true, this.cache.containsItem("CountryTest"));
    }

    @Test
    void hitsMissesAndRequestsTest(){
        Country c1 = new Country("c1");
        cache.addToCache("c1", c1);
        cache.getCountryFromCache("c1");
        cache.getCountryFromCache("c1");
        cache.getCountryFromCache("null");
        assertEquals(2, cache.getHits());
        assertEquals(1, cache.getMisses());
        assertEquals(3, cache.getRequests());
    }

    @Test
    void cleanAfterTimeTest() throws InterruptedException {
        Country c1 = new Country("c1");
        cache.addToCache("c1", c1);
        cache.cacheTimer("c1", 5);
        Thread.sleep(10); // wait for item to be removed
        assertEquals(0, this.cache.getCacheSize());
    }
}
