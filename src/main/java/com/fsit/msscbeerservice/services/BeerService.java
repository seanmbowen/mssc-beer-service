package com.fsit.msscbeerservice.services;

import com.fsit.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

/**
 * Created by: seanbowen on 2022-05-12
 * Architecting Solutions. Simply.
 */
@Deprecated(since = "2.0.0")
public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
