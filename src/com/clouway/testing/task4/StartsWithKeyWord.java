package com.clouway.testing.task4;

public class StartsWithKeyWord implements Endpoint {
    private String URL;

    public StartsWithKeyWord(String URL){
        this.URL = URL;
    }

    public boolean matches(String URL) {
        return this.URL.startsWith(URL);
    }

}
