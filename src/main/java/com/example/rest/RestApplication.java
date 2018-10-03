package com.example.rest;

import com.example.rest.auction.Auction;
import com.example.rest.auction.AuctionRepository;
import com.example.rest.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    public CommandLineRunner insertToDb(AuctionRepository auctionRepository) {
        return args -> {
            User user = new User();
            user.setUsername("user1");

            Auction auction = new Auction();
            auction.setName("Auction1");
            auction.setBidders(Collections.singleton(user));
            auctionRepository.save(auction);
        };
    }
}
