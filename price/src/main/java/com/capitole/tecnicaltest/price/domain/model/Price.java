package com.capitole.tecnicaltest.price.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Price {

    private LocalDateTime applicationDate;

    private Long productId;

    private Long brandId;

    private Double price;

    private Long priceList;
}
