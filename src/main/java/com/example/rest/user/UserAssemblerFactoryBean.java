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
public class UserAssemblerFactoryBean implements FactoryBean<UserAssemblerFactoryBean.UserAssembler> {
    private Assembler<RoleDTO, Role> roleAssembler;

    @Override
    public UserAssembler getObject() {
        return new UserAssembler(roleAssembler);
    }

    @Override
    public Class<?> getObjectType() {
        return UserAssembler.class;
    }

    @AllArgsConstructor
    static class UserAssembler implements Assembler<UserDTO, User> {
        private Assembler<RoleDTO, Role> roleAssembler;

        @Override
        public User assemble(UserDTO source) {
            User user = new User();
            user.setUsername(source.getUsername());
            user.setPassword(source.getPassword());
            user.setRoles(source.getRoles().stream().map(roleAssembler::assemble).collect(Collectors.toSet()));
            return user;
        }
    }
}
