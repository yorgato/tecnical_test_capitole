package com.capitole.tecnicaltest.price.application.service;

import com.capitole.tecnicaltest.price.domain.model.Price;
import com.capitole.tecnicaltest.price.infrastructure.adapter.PriceRepositoryH2Impl;
import com.capitole.tecnicaltest.price.infrastructure.exception.PriceNotFoundException;
import com.capitole.tecnicaltest.price.util.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class DomainPriceServiceTest {

    @Mock
    private PriceRepositoryH2Impl priceRepository;
    private final Long productId = 35455L;
    private final Long brandId = 1L;

    @BeforeEach
    public void setUp() {
    }

    @Test
    void listOfPricesWhenPriceIsCorrect() {

        List<Price> listOfPrices = getListOfPrices();

        listOfPrices.forEach(price -> {
            when(priceRepository.getPriceByDate(price.getApplicationDate(), productId, brandId)).thenReturn(Optional.of(price));

            Optional<Price> result = priceRepository.getPriceByDate(price.getApplicationDate(), productId, brandId);
            Assertions.assertEquals(result, Optional.of(price));
        });
    }

    @Test
    void listOfPricesWhenInformationDoesNotExist() {

        Price price = getPrice("2020-01-14 10.00.00");

        when(priceRepository.getPriceByDate(price.getApplicationDate(), productId, brandId))
                .thenThrow(PriceNotFoundException.class);

        Assertions.assertThrows(PriceNotFoundException.class, () -> {
            priceRepository.getPriceByDate(price.getApplicationDate(), productId, brandId);
        });
    }

    protected List<Price> getListOfPrices() {
        return new ArrayList<>(Arrays.asList(
                getPrice("2020-06-14 10.00.00"),
                getPrice("2020-06-14 16.00.00"),
                getPrice("2020-06-14 21.00.00"),
                getPrice("2020-06-15 10.00.00"),
                getPrice("2020-06-16 21.00.00")
        ));
    }

    protected Price getPrice(String applicationDate) {
        return Price
                .builder()
                .applicationDate(DateUtils.parseToLocalDateTime(applicationDate))
                .productId(productId)
                .brandId(brandId)
                .build();
    }

}