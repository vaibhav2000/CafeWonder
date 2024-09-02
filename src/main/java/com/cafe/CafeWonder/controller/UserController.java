package com.cafe.CafeWonder.controller;

import com.cafe.CafeWonder.dto.UserDTO;
import com.cafe.CafeWonder.entity.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cafe.CafeWonder.service.CakeService;
import com.cafe.CafeWonder.service.UserService;
import com.cafe.CafeWonder.validator.ICustomValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private CakeService cakeService;

    @Autowired
    private ICustomValidator validator;
    
    @Autowired
    private BCryptPasswordEncoder bcrpytPasswordEncoder;
    
    

    @GetMapping("/register")
    public String registerUserget(Model model)
    {
        model.addAttribute("passedUser",new UserDTO());
        return "register.html";
    }

    @PostMapping("/register")
    public String registerUserpost(@ModelAttribute("passedUser") UserDTO userDTO, BindingResult result)
    {
    
    	result = validator.validateUser(result,userDTO);
	
    	if(result.hasErrors())
    		return "register.html";
    	
    	User user = new User();
    	user.setActive(true);
    	
    	
    	user.setFirstname(userDTO.getFirstname());
    	user.setLastname(userDTO.getLastname());
    	user.setUsername(userDTO.getUsername());
    	user.setEmail(userDTO.getEmail());
    	user.setPassword(bcrpytPasswordEncoder.encode(userDTO.getPassword()));
    	user.setPhone(userDTO.getPhone());
    	user.setRole("ROLE_USER");
    	
    	userService.addUser(user);
    	
        return "registrationsuccessful.html";
    }
    
    
    @GetMapping("/login")
    public String loginUser()
    {
    	System.out.println("IN THE LOGIN GET PAGE");	
    	return "login.html";
    }

}
