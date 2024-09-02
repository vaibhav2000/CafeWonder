package com.cafe.CafeWonder.service;

import java.util.List;

import com.cafe.CafeWonder.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.CafeWonder.entity.Cake;
import com.cafe.CafeWonder.repository.CakeRepository;

@Service
public class CakeService {
	
	@Autowired 
	private CakeRepository cakeRepository;

	@Autowired
	private UserService userService;

	public void addCake(Cake cake)
	{
		User user = userService.getLoggedInUser();

		if(user == null)
			return;

		cakeRepository.save(cake);
	}

	public List<Cake> getAllCakes()
	{
		return cakeRepository.findAll();
	}


}
