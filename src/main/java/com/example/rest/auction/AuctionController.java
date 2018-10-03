package com.example.rest.auction;

import com.example.rest.assembler.Assembler;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("auctions")
public class AuctionController {
    private Assembler<Auction, AuctionDTO> assembler;
    private AuctionRepository auctionRepository;

    @GetMapping("all")
    @Transactional
    public List<AuctionDTO> getAuctions() {
        List<Auction> all = auctionRepository.findAll();
        return all.stream()
                .map(assembler::assemble)
                .collect(Collectors.toList());
    }
}
