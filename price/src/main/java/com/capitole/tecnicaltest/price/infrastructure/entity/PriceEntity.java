package com.capitole.tecnicaltest.price.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "PRICES")
@AllArgsConstructor
@NoArgsConstructor
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private Date START_DATE;
    private Date END_DATE;
    private Long BRAND_ID;
    private String CURR;
    private Double PRICE;
    private Long PRICE_LIST;
    private Long PRIORITY;
    private Long PRODUCT_ID;

}
