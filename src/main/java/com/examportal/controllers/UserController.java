package com.examportal.controllers;

import com.examportal.model.Role;
import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    // creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        Role role = new Role();
        role.setRoleId(45L);
        role.setRolename("NORMAL");

        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(userRole);
        return this.userService.createUser(user, userRoles);

    }

    //get All user
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = this.userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    //getUser
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        this.userService.deleteUser(userId);
    }
}
