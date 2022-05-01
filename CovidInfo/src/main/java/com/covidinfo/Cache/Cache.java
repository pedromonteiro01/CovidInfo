package com.covidinfo.Cache;

import java.util.HashMap;

import com.covidinfo.entity.Country;

public class Cache {

    public HashMap<String, Country> cacheMap = new HashMap<>();
    private int hits = 0;
    private int misses = 0;
    private int requests = 0;

    public Cache() {
    }

    public int getHits() {
        return hits;
    }

    public void setHits() {
        this.hits +=1;
    }

    public int getMisses() {
        return misses;
    }

    public void setMisses() {
        this.misses +=1;
    }

    public int getRequests() {
        return requests;
    }

    public void setRequests() {
        this.requests +=1;
    }

    public void addToCache(String key, Country value) {
        cacheMap.put(key, value);
    }

    public Country getCountryFromCache(String key) {
        if (cacheMap.containsKey(key)) { // if item in cache return item, else increase number of misses
            setHits();
            setRequests();
            return cacheMap.get(key);
        }
        setMisses();
        setRequests();
        return null;
    }

    public int getCacheSize() {
        return cacheMap.size();
    }

    // if country is in cache, then return it
    public boolean containsItem(String key) {
        return cacheMap.containsKey(key);
    }

    public void clearCache() {
        cacheMap.clear();
    }

    public void cacheTimer(String key, int timeToLive){
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        cacheMap.remove(key);
                    }
                },
                timeToLive // item stays in cache for 2 minutes (120000ms) 
        );
    }
}
