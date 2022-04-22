package com.covidinfo.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CovidService {
    private static String uri = "https://covid-193.p.rapidapi.com/statistics";
    private static String apiHost = "covid-193.p.rapidapi.com";
    private static String key = "f9d228bff2msh75b28bdd54a0e4fp105b45jsn191ab95e10fa";

    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchCovidData() throws IOException, InterruptedException, ParseException {
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create(uri))
		.header("X-RapidAPI-Host", apiHost)
		.header("X-RapidAPI-Key", key)
        .header("Content-Type", "application/json")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());

        JsonArray covidData = getJsonArray(response);

        ArrayList<String> countries = getCountries(covidData);
        for (String c : countries)
            System.out.println(c);
    }

    private JsonArray getJsonArray(HttpResponse<String> response) {
        //Convert HttpResponse to String
        String responseStr = response.body().toString();

        //Convert String to JsonObject (gson)
        JsonObject json = JsonParser.parseString(responseStr).getAsJsonObject();

        //Convert JsonObject to JsonArray (can be iterated)
        JsonArray jsonArray = json.getAsJsonArray("response");

        return jsonArray;
    }

    private ArrayList<String> getCountries(JsonArray arr) {
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            JsonObject objectJSON = (JsonObject) arr.get(i);
            array.add(objectJSON.get("country").toString());
        }
        return array;
    }
}
