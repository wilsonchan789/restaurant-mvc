package com.tandtseafoodedmonds.restaurantmvc.models.data;

import com.tandtseafoodedmonds.restaurantmvc.models.*;

import java.util.ArrayList;


public class MenuItem {
    private ArrayList<Menu> menus = new ArrayList<>();
    private static MenuItem instance;

    private MenuFieldData<Category> categories = new MenuFieldData<>();
    private MenuFieldData<Price> prices = new MenuFieldData<>();
    private MenuFieldData<Spicy> spicys = new MenuFieldData<>();
    private MenuFieldData<Pound> pounds = new MenuFieldData<>();


    private MenuItem() { MenuItemImporter.loadData(this); }


    public static MenuItem getInstance() {
        if (instance == null) {
            instance = new MenuItem();
        }
        return instance;
    }

    public Menu findById(int id) {
        for (Menu menu : menus) {
            if (menu.getId() == id)
                return menu;
        }

        return null;
    }

    public ArrayList<Menu> findAll() {
        return menus;
    }


    public ArrayList<Menu> findByColumnAndValue(MenuFieldType column, String value) {

        ArrayList<Menu> matchingMenus = new ArrayList<>();

        for (Menu menu : menus) {
            if (getFieldByType(menu, column).contains(value))
                matchingMenus.add(menu);
        }

        return matchingMenus;
    }


    public ArrayList<Menu> findByValue(String value) {

        ArrayList<Menu> matchingMenus = new ArrayList<>();

        for (Menu menu : menus) {

            if (menu.getName().toLowerCase().contains(value)) {
                matchingMenus.add(menu);
                continue;
            }

            for (MenuFieldType column : MenuFieldType.values()) {
                if (column != MenuFieldType.ALL && getFieldByType(menu, column).contains(value)) {
                    matchingMenus.add(menu);
                    break;
                }
            }
        }

        return matchingMenus;
    }


    public void add(Menu menu) {
        menus.add(menu);
    }


    private static MenuField getFieldByType(Menu menu, MenuFieldType type) {
        switch(type) {
            case CATEGORY:
                return menu.getCategory();
            case PRICE:
                return menu.getPrice();
            case SPICY:
                return menu.getSpicy();
            case POUND:
                return menu.getPound();
        }

        throw new IllegalArgumentException("Cannot get field of type " + type);
    }

    public MenuFieldData<Category> getCategories() {
        return categories;
    }

    public MenuFieldData<Price> getPrices() {
        return prices;
    }

    public MenuFieldData<Spicy> getSpicys() {
        return spicys;
    }

    public MenuFieldData<Pound> getPounds() {
        return pounds;
    }
}

