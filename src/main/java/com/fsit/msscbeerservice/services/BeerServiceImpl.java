package com.fsit.msscbeerservice.services;

import com.fsit.msscbeerservice.domain.Beer;
import com.fsit.msscbeerservice.exception.NotFoundException;
import com.fsit.msscbeerservice.repositories.BeerRepository;
import com.fsit.msscbeerservice.web.mappers.BeerMapper;
import com.fsit.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by: seanbowen on 2022-05-12
 * Architecting Solutions. Simply.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override

    public BeerDto getBeerById(UUID beerId) {
        log.debug("Searching for beer: {}", beerId);
        return beerMapper
                .beerToBeerDto(beerRepository
                        .findById(beerId)
                        .orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        log.debug("Saving beer: {}", beerDto.getId());
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        log.debug("Updating beer: {}", beerId);

        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle());
        beer.setPrice(beerDto.getPrice());
        beerDto.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting beer {} from database", beerId);
        beerRepository.deleteById(beerId);
    }

    @Override
    public Iterable<BeerDto> getAllBeers() {
        return beerMapper.beerToBeerDtoList(beerRepository.findAll());
    }

    @Override
    public BeerDto getBeerByUpc(String upc) {
        log.debug("Searching for beer using upc: {}", upc);
        return beerMapper
                .beerToBeerDto(beerRepository
                        .findByUpc(upc)
                        .orElseThrow(NotFoundException::new));
    }
}
