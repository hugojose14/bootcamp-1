package com.bank.scotia.domain.service;

import com.bank.scotia.domain.exceptions.UnauthorizedErrorException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UnauthorizedErrorException {
        return new User("admin", "admin", new ArrayList<>());
    }
}
