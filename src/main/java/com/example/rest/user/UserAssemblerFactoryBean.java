package com.example.rest.user;

import com.example.rest.assembler.Assembler;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class UserAssemblerFactoryBean implements FactoryBean<UserAssemblerFactoryBean.UserAssembler> {

    @Override
    public UserAssembler getObject() {
        return new UserAssembler();
    }

    @Override
    public Class<?> getObjectType() {
        return UserAssembler.class;
    }

    static class UserAssembler implements Assembler<User, UserDTO> {

        @Override
        public UserDTO assemble(User source) {
            UserDTO userDTO = new UserDTO();
            userDTO.setName(source.getUsername());
            return userDTO;
        }
    }
}
