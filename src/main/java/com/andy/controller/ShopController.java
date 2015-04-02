package com.andy.controller;

import com.andy.model.*;
import com.andy.repo.AccountRepository;
import com.andy.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {

    @Autowired
    private ProductRepository productRepository;
/*
    @ModelAttribute("boxCart")
    public Cart createCart() {
        return new Cart();
    }*/

    public ShopController() {
        new Cart();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
         public String listUsers(ModelMap model, @ModelAttribute("search")SearchProduct searchProduct,  @ModelAttribute("boxCart") Cart cart, BindingResult result) {
        model.addAttribute("productsList", productRepository.findAll());



            model.put("boxCart", new Cart());

        return "index";
    }



}