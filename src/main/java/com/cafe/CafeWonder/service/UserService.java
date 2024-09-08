package com.cafe.CafeWonder.service;

import com.cafe.CafeWonder.entity.User;
import com.cafe.CafeWonder.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepository userRepository;
    public void addUser(User user)
    {
        userRepository.save(user);
        logger.info("User "+user.getUsername()+ " has been added to the database");
    }

    public User getLoggedInUser()
    {
        return userRepository.getUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
