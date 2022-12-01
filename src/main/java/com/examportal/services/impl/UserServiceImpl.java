package com.examportal.services.impl;

import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.repo.RoleRepository;
import com.examportal.repo.UserReposotory;
import com.examportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserReposotory userReposotory;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {
        User local = this.userReposotory.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already exist!!...");
            throw new Exception("User is already exist!!...");
        } else {
            for (UserRole ur : userRoles
            ) {
                roleRepository.save(ur.getRole());
            }
            String password=user.getPassword();

            user.setPassword(passwordEncoder.encode(password));
            user.setProfile("default.png");
            user.getUserRoles().addAll(userRoles);
             local = this.userReposotory.save(user);


        }

        return local;
    }

    @Override
    public User getUser(String username) {
      return  this.userReposotory.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userReposotory.deleteById(userId);

    }

    @Override
    public List<User> getAllUser() {
        return this.userReposotory.findAll();
    }


}
