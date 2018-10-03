package com.example.rest.auction;

import com.example.rest.user.UserDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class AuctionDTO {
    private String name;
    private Set<UserDTO> bidders;
}
