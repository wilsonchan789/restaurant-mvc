package com.tandtseafoodedmonds.restaurantmvc.controllers;

import com.tandtseafoodedmonds.restaurantmvc.models.Menu;
import com.tandtseafoodedmonds.restaurantmvc.models.MenuField;
import com.tandtseafoodedmonds.restaurantmvc.models.MenuFieldType;
import com.tandtseafoodedmonds.restaurantmvc.models.data.MenuItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "list")
public class ListController {

    private MenuItem menuItem = MenuItem.getInstance();

    @RequestMapping(value = "")
    public String list(Model model) {
        MenuFieldType[] fields = MenuFieldType.values();
        model.addAttribute("fields", fields);
        return "list";
    }

    @RequestMapping(value = "values")
    public String listColumnValues(Model model, @RequestParam MenuFieldType column) {

        if (column.equals(MenuFieldType.ALL)) {
            return "redirect:/list/all";
        }


        ArrayList<? extends MenuField> items;

        switch(column) {
            case CATEGORY:
                items = menuItem.getCategories().findAll();
                break;
            case PRICE:
                items = menuItem.getPrices().findAll();
                break;
            case SPICY:
                items = menuItem.getSpicys().findAll();
                break;
            case POUND:
            default:
                items = menuItem.getPounds().findAll();
        }

        model.addAttribute("title", "All " + column.getName() + " Values");
        model.addAttribute("column", column);
        model.addAttribute("items", items);

        return "list-column";
    }

    @RequestMapping(value = "jobs")
    public String listJobsByColumnAndValue(Model model,
                                           @RequestParam MenuFieldType column, @RequestParam String name) {

        ArrayList<Menu> menus = menuItem.findByColumnAndValue(column, name);

        model.addAttribute("title", "Menu items with " + column.getName() + ": " + name);
        model.addAttribute("menus", menus);

        return "list-menuitems";
    }

    @RequestMapping(value = "all")
    public String listAllJobs(Model model) {

        ArrayList<Menu> menus = menuItem.findAll();

        model.addAttribute("title", "All Menu Items");
        model.addAttribute("menus", menus);

        return "list-menuitems";
    }
}
