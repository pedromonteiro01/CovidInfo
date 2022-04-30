package com.covidinfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String newCases;
    private String activeCases;
    private String recoveredCases;
    private String totalCases;
    private String newDeaths;
    private String totalDeaths;
    private String totalTests;

    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }   

    public Country(String name, String newCases, String activeCases, String recoveredCases, String totalCases, String newDeaths, String totalDeaths, String totalTests) {
        this.name = name;
        this.newCases = newCases;
        this.activeCases = activeCases;
        this.recoveredCases = recoveredCases;
        this.totalCases = totalCases;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
        this.totalTests = totalTests;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewCases() {
        return this.newCases;
    }

    public void setNewCases(String newCases) {
        this.newCases = newCases;
    }

    public String getActiveCases() {
        return this.activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getRecoveredCases() {
        return this.recoveredCases;
    }

    public void setRecoveredCases(String recoveredCases) {
        this.recoveredCases = recoveredCases;
    }

    public String getTotalCases() {
        return this.totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getNewDeaths() {
        return this.newDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getTotalDeaths() {
        return this.totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getTotalTests() {
        return this.totalTests;
    }

    public void setTotalTests(String totalTests) {
        this.totalTests = totalTests;
    }
}