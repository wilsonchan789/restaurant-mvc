package com.tandtseafoodedmonds.restaurantmvc.models;

public enum MenuFieldType {

    CATEGORY ("Category"),
    PRICE ("Price"),
    SPICY ("Spicy"),
    POUND ("Pound"),
    ALL ("All");

    private final String name;

    MenuFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}


