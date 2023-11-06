package com.capitole.tecnicaltest.price.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Price {

    private LocalDateTime applicationDate;
    private Long productId;
    private Long brandId;
    private Double price;
    private Long priceList;
}
