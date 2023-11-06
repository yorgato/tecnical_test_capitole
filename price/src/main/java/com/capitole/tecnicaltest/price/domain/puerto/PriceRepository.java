package com.capitole.tecnicaltest.price.domain.puerto;

import com.capitole.tecnicaltest.price.domain.model.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {
    Optional<Price> getPriceByDate(LocalDateTime date, Long productId, Long brandId);
}
