package com.capitole.tecnicaltest.price.infrastructure.web.controller;

import com.capitole.tecnicaltest.price.application.service.DomainPriceServiceImpl;
import com.capitole.tecnicaltest.price.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/capitoleTest")
@Slf4j
class PriceController {

    @Autowired
    private final DomainPriceServiceImpl priceService;
    static final String PRICE_LIST_PATH = "getPrice";

    PriceController(DomainPriceServiceImpl priceService) {
        this.priceService = priceService;
    }

    @GetMapping(PRICE_LIST_PATH)
    ResponseEntity<?> getPrice(@RequestParam String date, @RequestParam Long productId, @RequestParam Long brandId) {
        LocalDateTime localDate = DateUtils.parseToLocalDateTime(date);
        return ResponseEntity.ok(priceService.getPriceByDate(localDate, productId, brandId));
    }

}
