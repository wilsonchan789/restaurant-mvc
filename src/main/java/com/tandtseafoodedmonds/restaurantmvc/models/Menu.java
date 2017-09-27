package com.tandtseafoodedmonds.restaurantmvc.models;

public class Menu {
    private int id;
    private static int nextId = 1;

    private String name;
    private Category category;
    private Price price;
    private Spicy spicy;
    private Pound pound;

    public Menu() {
        id = nextId;
        nextId++;
    }

    public Menu(String aName, Category aCategory, Price aPrice,
               Spicy aSpicy, Pound aPound) {

        this();

        name = aName;
        category = aCategory;
        price = aPrice;
        spicy = aSpicy;
        pound = aPound;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Spicy getSpicy() {
        return spicy;
    }

    public void setSpicy(Spicy spicy) {
        this.spicy = spicy;
    }

    public Pound getPound() {
        return pound;
    }

    public void setPound(Pound pound) {
        this.pound = pound;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        return id == menu.id;
    }

    @Override
    public int hashCode() {
        return id;
    }


}
