package com.cafe.CafeWonder.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfig {

    @Bean
    public UserDetailsService getUserDetailsService()
    {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(getUserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(
//                        auth -> auth.requestMatchers("/","/home","/user/register").permitAll()
//                        			.requestMatchers("/css/**").permitAll()
//                        			.anyRequest().authenticated())
//                .formLogin(login -> login.permitAll())
//                .logout(logout -> logout.permitAll())   ;

        
        http.authorizeHttpRequests(
                auth -> auth.requestMatchers("/","/home","/user/register").permitAll()
                			.requestMatchers("/css/**","/images/**").permitAll()
                			.anyRequest().authenticated())
        .formLogin(login -> login.usernameParameter("username").defaultSuccessUrl("/home", true).permitAll())
                .rememberMe(rememberMe -> rememberMe.key("uniqueAndSecret").tokenValiditySeconds(900))
                .logout(logout -> logout.logoutSuccessUrl("/home").permitAll());

        
        return http.build();
    }

}
