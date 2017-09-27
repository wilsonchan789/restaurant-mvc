package com.tandtseafoodedmonds.restaurantmvc.controllers;

import com.tandtseafoodedmonds.restaurantmvc.models.*;
import com.tandtseafoodedmonds.restaurantmvc.models.data.MenuItem;
import com.tandtseafoodedmonds.restaurantmvc.models.form.MenuForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "menu")
public class MenuController {

    private MenuItem menuItem = MenuItem.getInstance();

    // The detail display for a given Menu item at URLs like /menu?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        // TODO #1 - get the Menuitem with the given ID and pass it into the view
        model.addAttribute("menu", menuItem.findById(id));

        return "menuitem-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new MenuForm());
        return "new-menuitem";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid MenuForm menuForm, Errors errors) {

        if(errors.hasErrors()){
            model.addAttribute("errors", errors);
            return "new-menuitem";
        }

        Category aCategory = menuItem.getCategories().findById(menuForm.getCategotyId());
        Price aPrice = menuItem.getPrices().findById(menuForm.getPriceId());
        Spicy aSpicy = menuItem.getSpicys().findById(menuForm.getSpicyId());
        Pound aPound= menuItem.getPounds().findById(menuForm.getPoundId());

        Menu newMenu = new Menu(menuForm.getName(),aCategory, aPrice, aSpicy, aPound);
        menuItem.add(newMenu);
        int id = newMenu.getId();

        // Validate the MenuForm model, and if valid, create a
        // new Menu and add it to the menuItem data store. Then
        // redirect to the menu detail view for the new Menu.

        return "redirect:" + "?id=" + id;
    }

}