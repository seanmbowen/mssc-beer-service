package com.fsit.msscbeerservice.web.controller.v2;

import com.fsit.msscbeerservice.services.v2.BeerServiceV2;
import com.fsit.msscbeerservice.web.model.v2.BeerDtoV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by: seanbowen on 2022-05-12
 * Architecting Solutions. Simply.
 */
@RestController
@RequestMapping("/api/v2/beer")
@RequiredArgsConstructor
@Slf4j
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> handlePost(@RequestBody BeerDtoV2 beerDto) {
        log.debug("In handle post method...");
        BeerDtoV2 savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<String> handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        log.debug("In handle update method...");

        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        log.debug("In handle delete method...");
        beerService.deleteById(beerId);
    }
}
