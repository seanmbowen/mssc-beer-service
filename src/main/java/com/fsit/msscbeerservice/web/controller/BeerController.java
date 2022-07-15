package com.fsit.msscbeerservice.web.controller;

import com.fsit.msscbeerservice.services.BeerService;
import com.fsit.msscbeerservice.web.model.BeerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by: seanbowen on 2022-05-26
 * Architecting Solutions. Simply.
 */
@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Beer Controller V1")
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    @Operation(summary = "Get beer record from database")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create new beer record in database")
    public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    @Operation(summary = "Update existing beer record in database")
    public ResponseEntity<String> updateBeer(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {

        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete existing beer record from database")
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteById(beerId);
    }
}
