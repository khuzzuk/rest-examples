package com.example.rest.role;

import com.example.rest.assembler.Assembler;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class RoleDTOAssemblerFactoryBean implements FactoryBean<RoleDTOAssemblerFactoryBean.RoleDTOAssembler> {

    @Override
    public RoleDTOAssembler getObject() {
        return new RoleDTOAssembler();
    }

    @Override
    public Class<?> getObjectType() {
        return RoleDTOAssembler.class;
    }

    static class RoleDTOAssembler implements Assembler<Role, RoleDTO> {

        @Override
        public RoleDTO assemble(Role source) {
            RoleDTO role = new RoleDTO();
            role.setName(source.getName());
            return role;
        }
    }
}
