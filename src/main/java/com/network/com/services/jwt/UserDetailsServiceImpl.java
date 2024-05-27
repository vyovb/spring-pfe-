package com.network.com.services.jwt;


import com.network.com.entity.User;
import com.network.com.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service

public class UserDetailsServiceImpl implements UserDetailsManager {
    @Autowired
    private UserRepo userRepo;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findFirstByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    @Override
    public void createUser(UserDetails user) {

    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }
}
