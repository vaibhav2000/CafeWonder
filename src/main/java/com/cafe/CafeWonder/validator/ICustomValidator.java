package com.cafe.CafeWonder.validator;
import com.cafe.CafeWonder.dto.UserDTO;

import org.springframework.validation.BindingResult;

public interface ICustomValidator {
	
	public BindingResult validateUser(BindingResult result,UserDTO userdto);

}
