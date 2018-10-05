package com.example.rest.role;

import com.example.rest.assembler.Assembler;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class RoleAssemblerFactoryBean implements FactoryBean<RoleAssemblerFactoryBean.RoleAssembler> {

    @Override
    public RoleAssembler getObject() {
        return new RoleAssembler();
    }

    @Override
    public Class<?> getObjectType() {
        return RoleAssembler.class;
    }

    static class RoleAssembler implements Assembler<RoleDTO, Role> {

        @Override
        public Role assemble(RoleDTO source) {
            Role role = new Role();
            role.setName(source.getName());
            return role;
        }
    }
}
