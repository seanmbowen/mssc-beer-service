package com.fsit.msscbeerservice.services;

import com.fsit.msscbeerservice.web.model.BeerDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by: seanbowen on 2022-05-12
 * Architecting Solutions. Simply.
 */
@Service
@Log4j2
@Deprecated(since = "2.0.0")
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat")
                .beerStyle("Pale Ale").upc(12345L).build();
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
