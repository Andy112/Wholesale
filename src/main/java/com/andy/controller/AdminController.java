package com.andy.controller;

import com.andy.model.Account;
import com.andy.model.Employee;
import com.andy.model.ProductEntity;
import com.andy.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class AdminController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String dashBoard(ModelMap model) {


        return "dashboard";
    }



    ////////////////////////////////////////////////////////////////////////
    ///////////////    User Management ////////////////////////////////////


    @RequestMapping(value = "/allCustomers", method = RequestMethod.GET)
    public String listCustomers(@ModelAttribute("account") Account account, BindingResult result, ModelMap model) {

        model.addAttribute("accountsList", accountRepository.findByRole_Id(new Long(1)));

        return "allCustomers";
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("account") Account account, BindingResult result, HttpServletRequest request) {

        accountRepository.save(account);

        String header = request.getHeader("Referer");
        return "redirect:"+ header;
    }

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(@ModelAttribute("customer") Account account, BindingResult result) {

        accountRepository.save(account);

        return "redirect:/";
    }

    @RequestMapping("/deleteCustomer/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") Long customerId) {

        accountRepository.delete(accountRepository.findOne(customerId));

        return "redirect:/";
    }



    ////////////////////////////////////////////////////////////////////////
    ///////////////    Employees  Management   ////////////////////////////////////


    @RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
    public String listEmployees(@ModelAttribute("employee") Account account, BindingResult result, ModelMap model) {

        model.addAttribute("warehouseList", warehouseRepository.findAll());

        model.addAttribute("accountsList", accountRepository.findByRole_Id(new Long(2)));


        return "allEmployees";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Account account, BindingResult result, HttpServletRequest request) {


        if(result.hasErrors()){
            String header = request.getHeader("Referer");
            return "redirect:"+ header;
        }else{
            accountRepository.save(account);
            String header = request.getHeader("Referer");
            return "redirect:"+ header;
        }



    }

    @RequestMapping(value = "/editEmployee/{id}", method = RequestMethod.GET)
    public ModelAndView editEmployee(ModelAndView model, @PathVariable("id")Long id, @ModelAttribute("employee") Account employee, BindingResult result) {

        employee = accountRepository.findOne(id);

        model.addObject("employee", employee);
        model.setViewName("editEmployee");
        return model;
    }

    @RequestMapping(value = "/editEmployee/{id}", method = RequestMethod.POST)
    public String updateEmployee(@PathVariable("id")Long id, @Valid @ModelAttribute("employee")Employee employee, HttpServletRequest request) {



            accountService.updateEmployee(id, employee);
            String header = request.getHeader("Referer");
            return "redirect:"+ header;


    }

    @RequestMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Long userId, HttpServletRequest request) {

        accountRepository.delete(accountRepository.findOne(userId));

        String header = request.getHeader("Referer");
        return "redirect:"+ header;
    }



    ////////////////////////////////////////////////////////////////////////
    ///////////////    Product Management ////////////////////////////////////


 @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") ProductEntity product, BindingResult result, HttpServletRequest request) {

        productRepository.save(product);

        String header = request.getHeader("Referer");
        return "redirect:"+ header;
    }

    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable("id")Long id, @ModelAttribute("product") ProductEntity product, BindingResult result) {

        product = productRepository.findOne(id);



        return "allProducts";
    }


    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProduct(@ModelAttribute("product") ProductEntity product, BindingResult result) {

        productRepository.save(product);

        return "allProducts";
    }

    @RequestMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId,HttpServletRequest request ) {

        productRepository.delete(productRepository.findOne(productId));

        String header = request.getHeader("Referer");
        return "redirect:"+ header;
    }

        @RequestMapping(value = "/allProducts", method = RequestMethod.GET)
        public String listProducts(@ModelAttribute("product") ProductEntity product, BindingResult result, ModelMap model) {

            model.addAttribute("productList", productRepository.findAll());

            model.addAttribute("warehouseList", warehouseRepository.findAll());

            return "allProducts";


    }


    ////////////////////////////////////////////////////////////////////////
    ///////////////    Order Management ////////////////////////////////////

    @RequestMapping(value = "/allOrder", method = RequestMethod.GET)
    public String listOrder(@ModelAttribute("order") ProductEntity product, BindingResult result, ModelMap model) {

        model.addAttribute("orderList", orderRepository.findAll());

        return "allOrder";
    }

    @RequestMapping("/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable("orderId") Long orderId, HttpServletRequest request) {

        orderRepository.delete(orderRepository.findOne(orderId));

        String header = request.getHeader("Referer");
        return "redirect:"+ header;
    }

}