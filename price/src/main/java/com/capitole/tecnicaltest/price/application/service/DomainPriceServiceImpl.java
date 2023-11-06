package com.capitole.tecnicaltest.price.application.service;

import com.capitole.tecnicaltest.price.domain.model.Price;
import com.capitole.tecnicaltest.price.domain.puerto.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DomainPriceServiceImpl implements DomainPriceService {

    private final PriceRepository priceRepository;

    public DomainPriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price getPriceByDate(LocalDateTime date, Long productId, Long brandId) {
        return priceRepository.getPriceByDate(date, productId, brandId).get();
    }
}
