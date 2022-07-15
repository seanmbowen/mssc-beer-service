package com.fsit.msscbeerservice.web.mappers;

import com.fsit.msscbeerservice.domain.Beer;
import com.fsit.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

/**
 * Created by: seanbowen on 2022-07-14
 * Architecting Solutions. Simply.
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

    Iterable<BeerDto> beerToBeerDtoList(Iterable<Beer> beer);
}
