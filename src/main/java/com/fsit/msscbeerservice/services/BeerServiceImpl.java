package com.fsit.msscbeerservice.services;

import com.fsit.msscbeerservice.web.model.BeerDto;
import com.fsit.msscbeerservice.web.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by: seanbowen on 2022-05-12
 * Architecting Solutions. Simply.
 */
@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.ALE)
                .upc(12345L).version(1)
                .price(new BigDecimal("123"))
                .quantityOnHand(100).build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        log.debug("Updating beer: {}", beerId);
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting beer {} from database", beerId);
    }
}
