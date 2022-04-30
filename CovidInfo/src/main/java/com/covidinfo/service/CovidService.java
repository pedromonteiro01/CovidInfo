package com.covidinfo.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.covidinfo.entity.Country;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class CovidService {

    public static String getCovidData() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://covid-193.p.rapidapi.com/statistics"))
		.header("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
		.header("X-RapidAPI-Key", "f9d228bff2msh75b28bdd54a0e4fp105b45jsn191ab95e10fa")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonObject = new JSONObject(response.body().toString());

        if (jsonObject.get("response").toString() == null)
            return null;

        JSONArray jsonArray = new JSONArray(jsonObject.get("response").toString());
        //System.out.println("----"+jsonArray);

        return jsonArray.toString();
    }

    public static ArrayList<String> getCountries() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://covid-193.p.rapidapi.com/statistics"))
		.header("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
		.header("X-RapidAPI-Key", "f9d228bff2msh75b28bdd54a0e4fp105b45jsn191ab95e10fa")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonObject = new JSONObject(response.body().toString());

        if (jsonObject.get("response").toString() == null)
            return null;

        ArrayList<String> countries = new ArrayList<>();
        //System.out.println("----"+jsonArray);
        JSONArray jsonArray = new JSONArray(jsonObject.get("response").toString());
        for (int i = 0; i < jsonArray.length(); ++i) {
            JSONObject jsn = jsonArray.getJSONObject(i);
            countries.add(jsn.getString("country"));
        }

        return countries;
    }

    public static ArrayList<Country> getCountriesData() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://covid-193.p.rapidapi.com/statistics"))
		.header("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
		.header("X-RapidAPI-Key", "f9d228bff2msh75b28bdd54a0e4fp105b45jsn191ab95e10fa")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonObject = new JSONObject(response.body().toString());

        if (jsonObject.get("response").toString() == null)
            return null;

        ArrayList<Country> covidDataCountry = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(jsonObject.get("response").toString());
        for (int i = 0; i < jsonArray.length(); ++i) {
            Country c = new Country();
            JSONObject jsn = jsonArray.getJSONObject(i);
            JSONObject jsnTests = jsn.getJSONObject("tests");
            JSONObject jsnCases = jsn.getJSONObject("cases");
            JSONObject jsnDeaths = jsn.getJSONObject("deaths");
            c.setName(jsn.getString("country"));
            c.setNewCases(jsnCases.get("new").toString());
            c.setActiveCases(jsnCases.get("active").toString());
            c.setNewDeaths(jsnDeaths.get("new").toString());
            c.setRecoveredCases(jsnCases.get("recovered").toString());
            c.setTotalCases(jsnCases.get("total").toString());
            c.setTotalDeaths(jsnDeaths.get("total").toString());
            c.setTotalTests(jsnTests.get("total").toString());
            System.out.println(jsn.get("tests").toString());
            covidDataCountry.add(c);
        }

        return covidDataCountry;
    }

    public static ArrayList<Country> getCountryByName(String name) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://covid-193.p.rapidapi.com/statistics"))
		.header("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
		.header("X-RapidAPI-Key", "f9d228bff2msh75b28bdd54a0e4fp105b45jsn191ab95e10fa")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonObject = new JSONObject(response.body().toString());

        if (jsonObject.get("response").toString() == null)
            return null;
            ArrayList<Country> countryData = new ArrayList<>();
            Country c = new Country();
            JSONArray jsonArray = new JSONArray(jsonObject.get("response").toString());
            for (int i = 0; i < jsonArray.length(); ++i) {
                JSONObject jsn = jsonArray.getJSONObject(i);
                JSONObject jsnTests = jsn.getJSONObject("tests");
                JSONObject jsnCases = jsn.getJSONObject("cases");
                JSONObject jsnDeaths = jsn.getJSONObject("deaths");
                if (jsn.get("country").toString().equals(name)) {
                    System.out.println("Found");
                    c.setName(name);
                    c.setNewCases(jsnCases.get("new").toString());
                    c.setActiveCases(jsnCases.get("active").toString());
                    c.setNewDeaths(jsnDeaths.get("new").toString());
                    c.setRecoveredCases(jsnCases.get("recovered").toString());
                    c.setTotalCases(jsnCases.get("total").toString());
                    c.setTotalDeaths(jsnDeaths.get("total").toString());
                    c.setTotalTests(jsnTests.get("total").toString());
                    System.out.println(jsn.get("tests").toString());
                    countryData.add(c);
                }
        }
        return countryData;
    }

}
