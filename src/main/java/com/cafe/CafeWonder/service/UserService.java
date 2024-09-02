package com.cafe.CafeWonder.service;

import com.cafe.CafeWonder.entity.User;
import com.cafe.CafeWonder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void addUser(User user)
    {
        userRepository.save(user);
    }

    public User getLoggedInUser()
    {
        return userRepository.getUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
