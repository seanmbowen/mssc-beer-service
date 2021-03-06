package com.fsit.msscbeerservice.services;

import com.fsit.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

/**
 * Created by: seanbowen on 2022-05-12
 * Architecting Solutions. Simply.
 */
public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);

    Iterable<BeerDto> getAllBeers();

    BeerDto getBeerByUpc(String upc);
}
