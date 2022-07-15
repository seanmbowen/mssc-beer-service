package com.fsit.msscbeerservice.web.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by: seanbowen on 2022-07-15
 * Architecting Solutions. Simply.
 */
@JsonTest
@Slf4j
@ActiveProfiles("kebab")
class BeerDtoKebabTest extends BaseTest {

    @Test
    void testSerializeDto() throws Exception {
        BeerDto beerDto = getDto();

        log.info(object.writeValueAsString(beerDto));
    }

    @Test
    void testDeserializeDto() throws Exception {
        String json = "{\"id\":\"e2916a48-730a-4f98-9e6c-5f9a4f163325\",\"version\":1,\"created-date\":\"2022-07-15T13:54:30.824772-04:00\",\"last-modified-date\":\"2022-07-15T13:54:30.830497-04:00\",\"beer-name\":\"Heineken\",\"beer-style\":\"LAGER\",\"upc\":12342344,\"price\":12.99,\"quantity-on-hand\":200}";

        BeerDto beerDto = object.readValue(json, BeerDto.class);
        log.info(beerDto.toString());
    }
}
