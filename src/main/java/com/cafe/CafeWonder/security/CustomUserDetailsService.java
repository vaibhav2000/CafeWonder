package com.cafe.CafeWonder.security;

import com.cafe.CafeWonder.entity.User;
import com.cafe.CafeWonder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.getUserByName(username);

        if(user == null)
            throw new UsernameNotFoundException("USER NOT PRESENT IN THE DATABASE");


        return new CustomUserDetails(user);
    }
}
