package com.example.rest.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private UserRepository userRepository;

    @GetMapping(path = "all", produces = {"application/json", "application/xml"})
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }
}
