package com.examportal.services.impl;

import com.examportal.model.User;
import com.examportal.repo.UserReposotory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserReposotory userReposotory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userReposotory.findByUsername(username);
        if (user==null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("NO User Found");
        }
        return user;
    }
}
