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

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

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
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder().beerName("Galaxy Cat")
                    .beerStyle(BeerStyle.ALE)
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("11.95"))
                    .build());

            beerRepository.save(Beer.builder().beerName("Heineken")
                    .beerStyle(BeerStyle.GOSE)
                    .quantityToBrew(100)
                    .minOnHand(10)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("7.95"))
                    .build());
        }

        Iterable<Beer> beerList = beerRepository.findAll();

        for (Beer beer : beerList) {
            log.info("Beer ID from DB: {}", beer.getId());
        }
    }
}
