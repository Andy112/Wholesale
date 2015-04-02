package com.andy.controller;

import com.andy.model.Account;
import com.andy.model.Customer;
import com.andy.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;



@Controller
public class RegisterController {

    @Autowired
    AccountRepository accountRepository;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addUserPage(@ModelAttribute("account")Account acccount, BindingResult result) {

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("account")Account account, BindingResult result) {

        //TODO if the page header was addTOCart refer

        if(result.hasErrors())
        {
            return "register";
        }else{

            accountRepository.save(account);
            return "registersuccess";
        }

    }
}
