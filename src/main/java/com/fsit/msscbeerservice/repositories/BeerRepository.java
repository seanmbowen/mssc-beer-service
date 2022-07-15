package com.fsit.msscbeerservice.repositories;

import com.fsit.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by: seanbowen on 2022-07-12
 * Architecting Solutions. Simply.
 */
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
    Optional<Beer> findByUpc(String upcId);
}
