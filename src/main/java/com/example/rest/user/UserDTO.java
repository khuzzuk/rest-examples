package com.example.rest.user;

import com.example.rest.role.RoleDTO;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private String username;
    private String password;
    private Set<RoleDTO> roles;
}
