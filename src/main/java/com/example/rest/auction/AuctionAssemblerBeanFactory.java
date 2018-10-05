package com.example.rest.auction;

import com.example.rest.assembler.Assembler;
import com.example.rest.user.User;
import com.example.rest.user.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class AuctionAssemblerBeanFactory implements FactoryBean<AuctionAssemblerBeanFactory.AuctionAssembler> {
    private Assembler<User, UserDTO> userAssembler;

    @Override
    public AuctionAssembler getObject() {
        return new AuctionAssembler(userAssembler);
    }

    @Override
    public Class<?> getObjectType() {
        return AuctionAssembler.class;
    }

    @AllArgsConstructor
    static class AuctionAssembler implements Assembler<Auction, AuctionDTO> {
        private Assembler<User, UserDTO> userAssembler;

        @Override
        public AuctionDTO assemble(Auction source) {
            AuctionDTO dto = new AuctionDTO();
            dto.setName(source.getName());
            dto.setBidders(source.getBidders().stream().map(userAssembler::assemble).collect(Collectors.toSet()));
            return dto;
        }
    }
}
