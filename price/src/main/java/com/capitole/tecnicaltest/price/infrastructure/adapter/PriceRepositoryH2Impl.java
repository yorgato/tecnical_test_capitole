package com.capitole.tecnicaltest.price.infrastructure.adapter;

import com.capitole.tecnicaltest.price.domain.model.Price;
import com.capitole.tecnicaltest.price.domain.puerto.PriceRepository;
import com.capitole.tecnicaltest.price.infrastructure.exception.PriceNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class PriceRepositoryH2Impl implements PriceRepository {
    
    @Override
    public Optional<Price> getPriceByDate(LocalDateTime date, Long productId, Long brandId) {

        return Optional.ofNullable(Price.builder().build());
        //throw new PriceNotFoundException();
    }
}
