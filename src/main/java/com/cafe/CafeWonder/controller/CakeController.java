package com.cafe.CafeWonder.controller;

import com.cafe.CafeWonder.entity.Cake;
import com.cafe.CafeWonder.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cake")
public class CakeController {

    @Autowired
    private CakeService cakeService;
    @PostMapping("/add")
    public String addCake(Cake cake)
    {
        cakeService.addCake(cake);
        return "redirect:/";
    }
}
