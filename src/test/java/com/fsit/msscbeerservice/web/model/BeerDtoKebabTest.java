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
        String json = "{\"id\":\"ca9b7a66-d06b-4119-b684-006d1b71b25b\",\"version\":1,\"created-date\":\"2022-07-15T15:26:23-0400\",\"last-modified-date\":\"2022-07-15T15:26:23-0400\",\"beer-name\":\"Heineken\",\"beer-style\":\"LAGER\",\"upc\":12342344,\"price\":\"12.99\",\"quantity-on-hand\":200}";

        BeerDto beerDto = object.readValue(json, BeerDto.class);
        log.info(beerDto.toString());
    }
}
