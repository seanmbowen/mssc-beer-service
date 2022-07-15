package com.fsit.msscbeerservice.bootstrap;

import com.fsit.msscbeerservice.domain.Beer;
import com.fsit.msscbeerservice.repositories.BeerRepository;
import com.fsit.msscbeerservice.web.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by: seanbowen on 2022-07-12
 * Architecting Solutions. Simply.
 */
@RequiredArgsConstructor
@Log4j2
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder().beerName("Mango Bobs")
                    .beerStyle(BeerStyle.LAGER)
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(28882782872828L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder().beerName("Galaxy Cat")
                    .beerStyle(BeerStyle.ALE)
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(28882782872818L)
                    .price(new BigDecimal("11.95"))
                    .build());
        }

        Iterable<Beer> beerList = beerRepository.findAll();

        for (Beer beer : beerList) {
            log.info("Beer ID from DB: {}", beer.getId());
        }
    }
}
