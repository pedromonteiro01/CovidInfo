package com.covidinfo.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class CovidService {
    private static String uri = "https://covid-193.p.rapidapi.com/countries";
    private static String apiHost = "covid-193.p.rapidapi.com";
    private static String key = "f9d228bff2msh75b28bdd54a0e4fp105b45jsn191ab95e10fa";

    @PostConstruct
    public void fetchCovidData() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://covid-193.p.rapidapi.com/statistics"))
		.header("X-RapidAPI-Host", apiHost)
		.header("X-RapidAPI-Key", key)
        .header("Content-Type", "application/json")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
