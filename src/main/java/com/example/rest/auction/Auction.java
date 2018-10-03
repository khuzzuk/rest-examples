package com.example.rest.auction;

import com.example.rest.user.User;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import java.util.Set;

@Data
@Entity
public class Auction {
    @SequenceGenerator(name = "auction_id_gen", sequenceName = "auction_id_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auction_id_gen")
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "bidders",
            joinColumns = @JoinColumn(name = "bidder_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> bidders;
}
