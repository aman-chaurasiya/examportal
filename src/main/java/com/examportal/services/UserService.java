package com.examportal.services;

import com.examportal.model.User;
import com.examportal.model.UserRole;

import java.util.List;
import java.util.Set;

public interface UserService {
    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;


    User getUser(String username);


    void deleteUser(Long userId);

    List<User> getAllUser();
}
