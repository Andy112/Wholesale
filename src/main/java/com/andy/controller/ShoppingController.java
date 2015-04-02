package com.andy.controller;

import com.andy.model.*;
import com.andy.repo.OrderRepository;
import com.andy.repo.ProductRepository;
import com.andy.repo.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping(value = "/cart" )
public class ShoppingController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    OrderRepository orderRepository;


   /* @ModelAttribute("boxCart")
    public Cart createNewCart(){
        return  new Cart();
    }*/


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String cartPage(@ModelAttribute("boxCart") Cart c, BindingResult result,
                                @PathVariable("productId")Long productId,
                                @RequestParam(value = "qty")int reqQty,
                                HttpSession session) {




        return  "viewCart";
    }


    @RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.POST)
    public ModelAndView updateProduct(@ModelAttribute("boxCart") Cart c, @ModelAttribute("search")SearchProduct searchProduct, @ModelAttribute("warehouseChosen")WarehouseChosen warehouseChosen, BindingResult result,
                                @PathVariable("productId")Long productId,
                                @RequestParam(value = "qty")int reqQty,
                                HttpSession session, ModelAndView model) {



        List<Cart> cartList = (List<Cart>)session.getAttribute("boxCart");

            Cart cart = new Cart();
        if(cartList == null){
            ProductEntity   product = productRepository.findOne(productId);
            cartList = new ArrayList<Cart>();
            c.setQty(reqQty);
            c.setProduct(product);
            cartList.add(c);

        }else{
            boolean flag = false;
            for (int count =0; count<cartList.size(); count++){

                ProductEntity  product = productRepository.findOne(productId);
                c.setProduct(product);
                //c.setQty(c.getQty());
                if (cartList.get(count).getId() == c.getId() && cartList.get(count).getProduct().getItemId() == c.getProduct().getItemId() ) {
                    cart.setProduct(c.getProduct());
                    cartList.get(count).setQty(cartList.get(count).getQty() + 1);
                    flag = true;
                    break;
                }
                if(flag){

                }

            }
            ProductEntity  product = productRepository.findOne(productId);
            if(!flag){
                c.setProduct(product);
                //c.setQty(c.getQty() + 1);
                cartList.add(c);
            }
        }
        session.setAttribute("boxCart", cartList);
        session.setAttribute("totalPrice", getTotalPrice(cartList));
        model.setViewName("viewCart");
        model.addObject("warehousesList", warehouseRepository.findAll());
        return model;
    }


    public float getTotalPrice(List<Cart> cartList){
        float total = 0;
        for (Cart cart: cartList){

            total +=(cart.getQty() * cart.getProduct().getItemPrice());
        }
        return total;
    }


    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String checkShopping(HttpSession session, @RequestParam("warehouseId")Long warehouseId){
        List<Cart> cartList = (List<Cart>)session.getAttribute("boxCart");

        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        OrderItem orderItem = new OrderItem();

        OrderEntity orderEntity = new OrderEntity();

        for (int count =0; count<cartList.size(); count++){
            orderItem.setProduct(cartList.get(0).getProduct());
            orderItem.setQty(cartList.get(0).getQty());
            orderItem.setWarehouse(warehouseRepository.findOne(warehouseId));
            orderItems.add(orderItem);
        }
        orderEntity.setOrderItems(orderItems);

        orderRepository.save(orderEntity);




        session.setAttribute("boxCart", new Cart());
        return "successpage";
    }
}
