package com.tandtseafoodedmonds.restaurantmvc.controllers;

import com.tandtseafoodedmonds.restaurantmvc.models.Menu;
import com.tandtseafoodedmonds.restaurantmvc.models.MenuFieldType;
import com.tandtseafoodedmonds.restaurantmvc.models.data.MenuItem;
import com.tandtseafoodedmonds.restaurantmvc.models.form.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("search")
public class SearchController {

    private MenuItem menuItem = MenuItem.getInstance();

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute(new SearchForm());
        return "search";
    }

    @RequestMapping(value = "results")
    public String search(Model model,
                         @ModelAttribute SearchForm searchForm) {

        ArrayList<Menu> menus;

        if (searchForm.getSearchField().equals(MenuFieldType.ALL)) {
            menus = menuItem.findByValue(searchForm.getKeyword());
        } else {
            menus = menuItem.findByColumnAndValue(searchForm.getSearchField(), searchForm.getKeyword());
        }

        model.addAttribute("menus", menus);

        return "search";
    }

}
