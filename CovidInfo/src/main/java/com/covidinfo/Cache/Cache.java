package com.covidinfo.Cache;

import java.util.HashMap;

import com.covidinfo.entity.Country;

public class Cache {

    private int hits, misses, requests, cleanTime = 0;

    public HashMap<String, Country> cacheMap = new HashMap<>();

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
