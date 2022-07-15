package com.fsit.msscbeerservice.web.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsit.msscbeerservice.bootstrap.BeerLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by: seanbowen on 2022-07-15
 * Architecting Solutions. Simply.
 */
@JsonTest
public class BaseTest {

    @Autowired
    ObjectMapper object;

    public BeerDto getDto() {
        return BeerDto.builder()
                .beerName("Heineken")
                .id(UUID.randomUUID())
                .beerStyle(BeerStyle.LAGER)
                .price(new BigDecimal("12.99"))
                .upc(BeerLoader.BEER_1_UPC)
                .version(1)
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .quantityOnHand(200)
                .build();
    }
}
