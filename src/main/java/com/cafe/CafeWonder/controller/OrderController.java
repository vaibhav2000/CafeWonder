package com.cafe.CafeWonder.controller;

import com.cafe.CafeWonder.entity.User;
import com.cafe.CafeWonder.service.OrderService;
import com.cafe.CafeWonder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;
    @GetMapping("/orders")
    public String getAllOrders(Model model)
    {
        User u = userService.getLoggedInUser();

        if(u.getRole().equals("ROLE_ADMIN"))
            model.addAttribute("orders",orderService.getAllOrders());
        else
            model.addAttribute("orders",u.getOrderDetailsList());

        return "orderlist.html";
    }

}
