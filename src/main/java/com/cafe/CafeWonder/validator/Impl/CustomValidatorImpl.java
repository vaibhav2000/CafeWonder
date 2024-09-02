package com.cafe.CafeWonder.validator.Impl;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.cafe.CafeWonder.dto.UserDTO;
import com.cafe.CafeWonder.validator.ICustomValidator;

@Component
public class CustomValidatorImpl implements ICustomValidator{
	

	@Override
	public BindingResult validateUser(BindingResult result, UserDTO userdto) {
		
		if(userdto.getFirstname() == null || userdto.getFirstname() == "")
			result.rejectValue("firstname", "error.user", "First name cannot be empty");
	
		if(userdto.getLastname() == null || userdto.getLastname() == "")
			result.rejectValue("lastname", "error.user", "Last name cannot be empty");
		
		if(userdto.getEmail() == null || (!userdto.getEmail().contains("@") || (!userdto.getEmail().contains(".com"))))
			result.rejectValue("email", "error.user", "Please provide valid email");
		
		if(userdto.getPhone() == null ||  !userdto.getPhone().chars().allMatch( Character::isDigit ) || userdto.getPhone().length() != 10 )
			result.rejectValue("phone", "error.user", "Please provide valid phone number");
			
		
		// TODO Auto-generated method stub
		return result;
	}

}
