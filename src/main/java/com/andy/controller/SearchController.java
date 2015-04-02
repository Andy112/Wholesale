package com.andy.controller;

import com.andy.model.Account;
import com.andy.model.Cart;
import com.andy.model.SearchProduct;
import com.andy.repo.AccountRepository;
import com.andy.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;




@Controller
public class SearchController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchProduct(ModelAndView model, @ModelAttribute("search")SearchProduct searchProduct, BindingResult result) {

        model.addObject("productsList", productRepository.findByItemNameLike(searchProduct.getSearchterm()));
        model.addObject("boxCart", new Cart());
        model.setViewName("search");
        return model;

    }
}
