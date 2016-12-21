package com.example.jose.simplenetworkconnections.model;

import java.util.List;

/**
 * This represents our JSON response object
 */
public class HouseResponse {
    private boolean success;
    private List<House> houses;

    public List<House> getHouses() {
        return houses;
    }

    public boolean isSuccess() {
        return success;
    }
}
