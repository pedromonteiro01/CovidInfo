package com.covidinfo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.covidinfo.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    public Country findByName(String name);
    public List<Country> findAll();
}