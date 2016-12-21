package com.example.jose.simplenetworkconnections.model;

/**
 * Created by Joe on 12/20/16.
 */
public class House {
    private String style;
    private String price;
    private String location;

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStyle(String style) {
        this.style = style;
    }


    public String getPrice() {
        return price;
    }

    public String getStyle() {
        return style;
    }

    public String getLocation() {
        return location;
    }
}
