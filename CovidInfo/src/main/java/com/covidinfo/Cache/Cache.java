package com.covidinfo.Cache;

import java.util.HashMap;

import com.covidinfo.entity.Country;

public class Cache {

    public HashMap<String, Country> cacheMap = new HashMap<>();
    private int hits = 0;
    private int misses = 0;
    private int requests = 0;
    private int cleanTime = 0;

    public Cache(int cleanTime) {
        this.cleanTime = cleanTime;
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
        if (cacheMap.containsKey(key)) {
            setHits();
            setRequests();
            return cacheMap.get(key);
        }
        setHits();
        setMisses();
        return null;
    }

    public void TimerCache(String obj){
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        cacheMap.remove(obj);
                    }
                },
                120000 // stays in cache for 2 minutes
                
        );
    }
}
