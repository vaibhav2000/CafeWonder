package com.cafe.CafeWonder.controller;


import com.cafe.CafeWonder.service.CakeService;
import com.cafe.CafeWonder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class DefaultController {

    @Autowired
    private CakeService cakeService;

    @GetMapping("/")
    public String basePage()
    {
        return "redirect:home";
    }


    @GetMapping("/home")
    public String defaultPage(Model model)
    {
        model.addAttribute("cakes",cakeService.getAllCakes());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("name",authentication.getName());

        return "homepage.html";
    }


}
