package com.capitole.tecnicaltest.price.util;

import com.capitole.tecnicaltest.price.domain.model.Price;
import com.capitole.tecnicaltest.price.infrastructure.entity.PriceEntity;
import org.modelmapper.ModelMapper;

public final class MapperUtils {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Price priceEntityToPrice(PriceEntity priceEntity) {
        return modelMapper.map(priceEntity, Price.class);
    }
}
