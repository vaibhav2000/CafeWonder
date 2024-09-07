package com.cafe.CafeWonder.controller;

import com.cafe.CafeWonder.entity.Cake;
import com.cafe.CafeWonder.entity.User;
import com.cafe.CafeWonder.exception.customexception.InvalidUserException;
import com.cafe.CafeWonder.service.CakeService;
import com.cafe.CafeWonder.service.OrderService;
import com.cafe.CafeWonder.service.UserService;
import com.cafe.CafeWonder.util.fileutils.IFileProcessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/cake")
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private IFileProcessor fileProcessor;

    @PostMapping("/order")
    public String orderCake(@RequestParam("cakeId") Long cakeId, Model model) {

        orderService.placeOrder(cakeId);
        model.addAttribute("cake", cakeService.getCake(cakeId));
        return "ordersuccessful.html";
    }

    @PostMapping("/delete")
    public String deleteCake(@RequestParam("cakeId") Long cakeId) throws InvalidUserException {

        cakeService.deleteCake(cakeId);
        return "redirect:/home";

    }

    @GetMapping("/add")
    public String addCakeGet(Model model) throws InvalidUserException
    {
        User user = userService.getLoggedInUser();

        if(!user.getRole().equals("ROLE_ADMIN"))
            throw new InvalidUserException("Operation not permitted for the current user");

        model.addAttribute("cake",new Cake());
        return "addCake.html";
    }


    @PostMapping("/add")
    public String addCakePost(@RequestParam("name") String name,@RequestParam("description") String description,@RequestParam("calories") Integer calories,@RequestParam("price") Integer price, @RequestParam("picture") MultipartFile file) throws Exception {

        fileProcessor.saveFile(file);

        Cake cake = new Cake();
        cake.setCakeName(name);
        cake.setDescription(description);
        cake.setCalories(calories);
        cake.setPrice(price);
        cake.setCakeImagePath(file.getOriginalFilename());
        cakeService.addCake(cake);

        return "addCakeResponse.html";
    }
}
