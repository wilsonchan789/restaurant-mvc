package com.tandtseafoodedmonds.restaurantmvc.controllers;

import com.tandtseafoodedmonds.restaurantmvc.models.User;
import com.tandtseafoodedmonds.restaurantmvc.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, String verify){
        model.addAttribute("verify", verify);

        if (!errors.hasErrors() && !verify.isEmpty() && user.getPassword().equals(verify)){
            userDao.save(user);
            model.addAttribute("title", "Welcome, " + user.getUsername());
            return "user/index";
        }else{
            String verifyError = "";
            if(verify.isEmpty() || !user.getPassword().equals(verify)){
                verifyError = "Please enter a matching Password";
            }
            model.addAttribute(user);
            model.addAttribute("title", "Add User");
            model.addAttribute("verifyError", verifyError);
            return "/user/add";
        }
    }
}
