package com.cafe.CafeWonder.controller;

import com.cafe.CafeWonder.entity.User;
import com.cafe.CafeWonder.exception.customexception.InvalidUserException;
import com.cafe.CafeWonder.service.OrderService;
import com.cafe.CafeWonder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;
    @GetMapping("/orders")
    public String getAllOrders(Model model) throws InvalidUserException
    {
        User user = userService.getLoggedInUser();

        if(user.getRole().equals("ROLE_ADMIN"))
            model.addAttribute("orders",orderService.getAllOrders());
        else
            model.addAttribute("orders",user.getOrderDetailsList());

        return "orderlist.html";
    }

    @PostMapping("/order/update")
    public String updateOrder(@RequestParam("orderId") Long orderId) throws InvalidUserException
    {
        User user = userService.getLoggedInUser();

        if(!user.getRole().equals("ROLE_ADMIN"))
            throw new InvalidUserException("Operation not permitted for the current user");

        orderService.updateOrder(orderId);

        return "redirect:/orders";
    }

}
