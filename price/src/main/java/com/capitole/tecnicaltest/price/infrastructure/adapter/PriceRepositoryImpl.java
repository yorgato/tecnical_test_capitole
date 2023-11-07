package com.capitole.tecnicaltest.price.infrastructure.adapter;

import com.capitole.tecnicaltest.price.domain.model.Price;
import com.capitole.tecnicaltest.price.domain.puerto.PriceRepository;
import com.capitole.tecnicaltest.price.infrastructure.entity.PriceEntity;
import com.capitole.tecnicaltest.price.infrastructure.exception.PriceNotFoundException;
import com.capitole.tecnicaltest.price.util.DateUtils;
import com.capitole.tecnicaltest.price.util.MapperUtils;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private final PriceRepositoryH2 priceRepositoryH2;

    public PriceRepositoryImpl(PriceRepositoryH2 priceRepositoryH2) {
        this.priceRepositoryH2 = priceRepositoryH2;
    }

    @Override
    public Optional<Price> getPriceByDate(LocalDateTime date, Long productId, Long brandId) {

        List<PriceEntity> prices = priceRepositoryH2
                .getPrice(DateUtils.parseToString(date), productId, brandId);

        Optional<PriceEntity> maxPriorityPrice = prices.stream()
                .max(Comparator.comparingLong(PriceEntity::getPRIORITY));

        if (maxPriorityPrice.isPresent()) {
            PriceEntity priceWithMaxPriority = maxPriorityPrice.get();
            return Optional.of(MapperUtils.priceEntityToPrice(priceWithMaxPriority));
        } else {
            throw new PriceNotFoundException();
        }
    }

}
