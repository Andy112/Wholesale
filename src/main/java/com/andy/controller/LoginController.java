package com.andy.controller;

import com.andy.model.Account;
import com.andy.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;




@Controller
public class LoginController {

    @Autowired
    AccountRepository accountRepository;



    @RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
    public String adminLogin(ModelMap model) {


        return "adminLogin";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage() {

        return "logout";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(ModelAndView model, @ModelAttribute("account")Account acccount, BindingResult result) {

         model.setViewName("register");
        return  model;
    }


}
