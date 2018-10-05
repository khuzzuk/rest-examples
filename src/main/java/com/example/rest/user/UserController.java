package com.example.rest.user;

import com.example.rest.assembler.Assembler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private UserRemoteService userRemoteService;
    private Assembler<User, UserDTO> userDTOAssembler;
    private Assembler<UserDTO, User> userAssembler;

    @GetMapping(path = "all", produces = {"application/json", "application/xml"})
    public Collection<User> getUsers() {
        return userRemoteService.getAll();
    }

    @RequestMapping("registerAdmin")
    public void registerUser(@RequestBody UserDTO userDTO) {
        userRemoteService.save(userAssembler.assemble(userDTO));
    }

    @GetMapping("user/{username}")
    public UserDTO getByUserName(@PathVariable String username) {
        User user = userRemoteService.getByUsername(username);
        return userDTOAssembler.assemble(user);
    }
}
