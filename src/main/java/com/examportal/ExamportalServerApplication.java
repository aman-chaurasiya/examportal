package com.examportal;

import com.examportal.model.Role;
import com.examportal.model.User;
import com.examportal.model.UserRole;
import com.examportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamportalServerApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(ExamportalServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("starting code...");
       /* User user = new User();
        user.setFirstname("Aman");
        user.setLastname("sunny");
        user.setUsername("shivam");
        user.setPhone("8858646374");
        user.setEmail("aman@gmail.com");
        user.setPassword("abc");
        user.setProfile("abc.png");

        Role role= new Role();
        role.setRoleId(55L);
        role.setRolename("ADMIN");

        Set<UserRole> userRoleSet= new HashSet<>();
        UserRole userRole=new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleSet.add(userRole);

        User savedUser = this.userService.createUser(user, userRoleSet);
        System.out.println(savedUser.getUsername());
*/

    }
}
