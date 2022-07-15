package com.fsit.msscbeerservice.web.controller.v2;

import com.fsit.msscbeerservice.services.v2.BeerServiceV2;
import com.fsit.msscbeerservice.web.model.v2.BeerDtoV2;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Beer Controller V2")
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    @GetMapping("/{beerId}")
    @Operation(summary = "Get beer record from database")
    public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Create new beer record in database")
    public ResponseEntity<String> handlePost(@RequestBody BeerDtoV2 beerDto) {
        log.debug("In handle post method...");
        BeerDtoV2 savedDto = beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location", "/api/v2/beer/" + savedDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    @Operation(summary = "Update existing beer record in database")
    public ResponseEntity<String> handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        log.debug("In handle update method...");

        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete existing beer record from database")
    public void deleteBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 beerDto) {
        log.debug("In handle delete method...");
        beerService.deleteById(beerId);
    }
}
