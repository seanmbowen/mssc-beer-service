package com.fsit.msscbeerservice.services.v2;

import com.fsit.msscbeerservice.web.model.v2.BeerDtoV2;
import com.fsit.msscbeerservice.web.model.v2.BeerStyleEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by: seanbowen on 2022-05-12
 * Architecting Solutions. Simply.
 */
@Service
@Log4j2
public class BeerServiceImplV2 implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return BeerDtoV2.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle(BeerStyleEnum.LAGER).upc("gXpuN5V").build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
        log.debug("Updating beer: {}", beerId);
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting beer {} from database", beerId);
    }
}
