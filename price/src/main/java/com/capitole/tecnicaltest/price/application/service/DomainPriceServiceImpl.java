package com.capitole.tecnicaltest.price.application.service;

import com.capitole.tecnicaltest.price.domain.model.Price;
import com.capitole.tecnicaltest.price.domain.puerto.PriceRepository;
import com.capitole.tecnicaltest.price.infrastructure.exception.ValidationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Service
public class DomainPriceServiceImpl implements DomainPriceService {

    private final PriceRepository priceRepository;

    public DomainPriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPriceByDate(LocalDateTime date, Long productId, Long brandId) {
        if (date == null) {
            throw new ValidationException();
        }

        if (Stream.of(productId, brandId)
                .anyMatch(value -> value == null || (value instanceof Long && ((Long) value) <= 0))) {
            throw new ValidationException();
        }

        Price price = priceRepository.getPriceByDate(date, productId, brandId).get();
        price.setApplicationDate(date);
        return price;
    }
}
