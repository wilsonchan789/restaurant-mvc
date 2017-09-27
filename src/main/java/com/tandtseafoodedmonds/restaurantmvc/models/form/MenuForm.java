package com.tandtseafoodedmonds.restaurantmvc.models.form;

import com.tandtseafoodedmonds.restaurantmvc.models.Category;
import com.tandtseafoodedmonds.restaurantmvc.models.Pound;
import com.tandtseafoodedmonds.restaurantmvc.models.Price;
import com.tandtseafoodedmonds.restaurantmvc.models.Spicy;
import com.tandtseafoodedmonds.restaurantmvc.models.data.MenuItem;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class MenuForm {
    @NotNull
    @Size(min=1, message = "Name may not be empty")
    private String name;

    @NotNull
    private int categotyId;

    @NotNull
    private int priceId;

    @NotNull
    private int spicyId;

    @NotNull
    private int poundId;

    private ArrayList<Category> categories;
    private ArrayList<Price> prices;
    private ArrayList<Spicy> spicys;
    private ArrayList<Pound> pounds;

    public MenuForm() {

        MenuItem menuItem = MenuItem.getInstance();

        categories = menuItem.getCategories().findAll();
        prices = menuItem.getPrices().findAll();
        spicys = menuItem.getSpicys().findAll();
        pounds = menuItem.getPounds().findAll();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Price> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<Price> prices) {
        this.prices = prices;
    }

    public ArrayList<Spicy> getSpicys() {
        return spicys;
    }

    public void setSpicys(ArrayList<Spicy> spicys) {
        this.spicys = spicys;
    }

    public ArrayList<Pound> getPounds() {
        return pounds;
    }

    public void setPounds(ArrayList<Pound> pounds) {
        this.pounds = pounds;
    }

    public int getCategotyId() {
        return categotyId;
    }

    public void setCategotyId(int categotyId) {
        this.categotyId = categotyId;
    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public int getSpicyId() {
        return spicyId;
    }

    public void setSpicyId(int spicyId) {
        this.spicyId = spicyId;
    }

    public int getPoundId() {
        return poundId;
    }

    public void setPoundId(int poundId) {
        this.poundId = poundId;
    }
}
