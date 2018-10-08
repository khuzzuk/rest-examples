package com.example.rest.user;

import com.example.rest.assembler.Assembler;
import com.example.rest.role.Role;
import com.example.rest.role.RoleDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class UserDTOAssemblerFactoryBean implements FactoryBean<UserDTOAssemblerFactoryBean.UserDTOAssembler> {
    private Assembler<Role, RoleDTO> roleDTOAssembler;

    @Override
    public UserDTOAssembler getObject() {
        return new UserDTOAssembler(roleDTOAssembler);
    }

    @Override
    public Class<?> getObjectType() {
        return UserDTOAssembler.class;
    }

    @AllArgsConstructor
    static class UserDTOAssembler implements Assembler<User, UserDTO> {
        private Assembler<Role, RoleDTO> roleDTOAssembler;

        @Override
        public UserDTO assemble(User source) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(source.getUsername());
            userDTO.setPassword(source.getPassword());
            userDTO.setRoles(source.getRoles().stream().map(roleDTOAssembler::assemble).collect(Collectors.toSet()));
            return userDTO;
        }
    }
}
