package com.tandtseafoodedmonds.restaurantmvc.models.form;

import com.tandtseafoodedmonds.restaurantmvc.models.MenuFieldType;

public class SearchForm {
    // The search options
    private MenuFieldType[] fields = MenuFieldType.values();

    // The selected search options
    private MenuFieldType searchField = MenuFieldType.ALL;

    // The search string
    private String keyword;

    public MenuFieldType getSearchField() {
        return searchField;
    }

    public void setSearchField(MenuFieldType searchField) {
        this.searchField = searchField;
    }

    public MenuFieldType[] getFields() {
        return fields;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
