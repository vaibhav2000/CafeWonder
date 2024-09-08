package com.cafe.CafeWonder.service;

import java.util.List;

import com.cafe.CafeWonder.exception.customexception.InvalidUserException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;

import com.cafe.CafeWonder.entity.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe.CafeWonder.entity.Cake;
import com.cafe.CafeWonder.repository.CakeRepository;

@Service
@Transactional
public class CakeService {

	private static final Logger logger = LoggerFactory.getLogger(CakeService.class);
	@Autowired 
	private CakeRepository cakeRepository;
	@Autowired
	private UserService userService;

	public void addCake(Cake c) throws InvalidUserException
	{
		User user = userService.getLoggedInUser();

		if(!user.getRole().equals("ROLE_ADMIN"))
			throw new InvalidUserException("Operation not permitted for the current user");

		cakeRepository.save(c);
		logger.info("Cake with ID: "+ c.getCakeId() + " added to the database");
	}

	public void deleteCake(long cakeId) throws InvalidUserException
	{
		User user = userService.getLoggedInUser();

		if(!user.getRole().equals("ROLE_ADMIN"))
			throw new InvalidUserException("Operation not permitted for the current user");

		cakeRepository.deleteById(cakeId);
		logger.info("Cake with ID: "+ cakeId + " deleted from the database");
	}

	public Cake getCake(Long cakeId)
	{
		return cakeRepository.findById(cakeId).get();
	}

	public List<Cake> getAllCakes()
	{
		return cakeRepository.findAll();
	}
}
