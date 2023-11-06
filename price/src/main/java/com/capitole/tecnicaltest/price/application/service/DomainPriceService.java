package com.capitole.tecnicaltest.price.application.service;

import com.capitole.tecnicaltest.price.domain.model.Price;

import java.time.LocalDateTime;

public interface DomainPriceService {
    Price getPriceByDate(LocalDateTime date, Long productId, Long brandId);
}
