package com.cafe.CafeWonder.service;

import java.util.List;
import org.slf4j.Logger;

import com.cafe.CafeWonder.entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.CafeWonder.entity.Cake;
import com.cafe.CafeWonder.repository.CakeRepository;

@Service
public class CakeService {

	private static final Logger logger = LoggerFactory.getLogger(CakeService.class);
	@Autowired 
	private CakeRepository cakeRepository;

	@Autowired
	private UserService userService;

	public void orderCake(Cake c)
	{
		User user = userService.getLoggedInUser();

		if(user == null)
			return;

		c.getUserList().add(user);

		cakeRepository.save(c);
		logger.info("Cake "+c.getCakeId() + " ordered by the user "+ user.getUsername());
	}

	public void addCake(Cake c)
	{
		cakeRepository.save(c);
		logger.info("Cake "+c.toString() + " saved to the database");
	}

	public Cake getCake(Long cakeId)
	{
		return cakeRepository.findById(cakeId).get();
	}

	public List<Cake> getAllCakes()
	{
		return cakeRepository.findAll();
	}

	public void deleteCake(long cakeId)
	{
		cakeRepository.deleteById(cakeId);
		logger.info("Cake with ID: "+ cakeId + " deleted from the database");
	}

}
