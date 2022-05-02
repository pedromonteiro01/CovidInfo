package com.covidinfo.repository;

import java.util.ArrayList;

import com.covidinfo.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
    Country findByName(String name); 
    ArrayList<Country> findAll(); 
}
