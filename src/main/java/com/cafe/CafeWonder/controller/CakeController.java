package com.cafe.CafeWonder.controller;

import com.cafe.CafeWonder.entity.Cake;
import com.cafe.CafeWonder.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cake")
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @PostMapping("/order")
    public String addCake(@RequestParam("cakeId") Long cakeId, Model model) {
        Cake cake = cakeService.getCake(cakeId);

        if (cake != null)
        {
            cakeService.addCake(cake);
            model.addAttribute("cake", cakeService.getCake(cakeId));
        }

        return "ordersuccessful.html";
    }
}
