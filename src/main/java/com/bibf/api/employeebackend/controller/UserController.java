package com.bibf.api.employeebackend.controller;

import com.bibf.api.employeebackend.model.User;
import com.bibf.api.employeebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*") //WildCard is not good
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    // Write the Postman post request and validate the api is working or not

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Write the Postman GET request and validate the api is working or not

}
