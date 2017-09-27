package com.tandtseafoodedmonds.restaurantmvc.models;

public class MenuField {
    private String value;
    private int id;
    private static int nextId = 1;

    public MenuField() {
        id = nextId;
        nextId++;
    }

    public MenuField(String aValue) {
        this();
        value = aValue;
    }

    public boolean contains(String value) {
        return this.value.toLowerCase().contains(value.toLowerCase());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String aValue) {
        value = aValue;
    }

    public String toString() {
        return value;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuField menuField = (MenuField) o;

        return id == menuField.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }

}
