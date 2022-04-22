package com.covidinfo.entity;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "continent", nullable = false)
    private String continent;

    @Column(name = "population", nullable = false)
    private int population;

    @Column(name = "new_cases", nullable = false)
    private int newCases;

    @Column(name = "active_cases", nullable = false)
    private int activeCases;

    @Column(name = "recovered_cases", nullable = false)
    private int recoveredCases;

    @Column(name = "total_cases", nullable = false)
    private int totalCases;

    @Column(name = "new_deaths", nullable = false)
    private int newDeaths;
    
    @Column(name = "total_deaths", nullable = false)
    private int totalDeaths;

    @Column(name = "tests", nullable = false)
    private int tests;

    @Column(name = "day", nullable = false)
    private int day;

    public Country() {
    }

    public Country(String name, String continent, int population) {
        this.name = name;
        this.continent = continent;
        this.population = population;
    }

    public Country(long id, String name, String continent, int population, int newCases, int activeCases, int recoveredCases, int totalCases, int newDeaths, int totalDeaths, int tests, int day) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.newCases = newCases;
        this.activeCases = activeCases;
        this.recoveredCases = recoveredCases;
        this.totalCases = totalCases;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
        this.tests = tests;
        this.day = day;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return this.continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getNewCases() {
        return this.newCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;
    }

    public int getActiveCases() {
        return this.activeCases;
    }

    public void setActiveCases(int activeCases) {
        this.activeCases = activeCases;
    }

    public int getRecoveredCases() {
        return this.recoveredCases;
    }

    public void setRecoveredCases(int recoveredCases) {
        this.recoveredCases = recoveredCases;
    }

    public int getTotalCases() {
        return this.totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public int getNewDeaths() {
        return this.newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public int getTotalDeaths() {
        return this.totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public int getTests() {
        return this.tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", continent='" + getContinent() + "'" +
            ", population='" + getPopulation() + "'" +
            ", newCases='" + getNewCases() + "'" +
            ", activeCases='" + getActiveCases() + "'" +
            ", recoveredCases='" + getRecoveredCases() + "'" +
            ", totalCases='" + getTotalCases() + "'" +
            ", newDeaths='" + getNewDeaths() + "'" +
            ", totalDeaths='" + getTotalDeaths() + "'" +
            ", tests='" + getTests() + "'" +
            ", day='" + getDay() + "'" +
            "}";
    }

}
