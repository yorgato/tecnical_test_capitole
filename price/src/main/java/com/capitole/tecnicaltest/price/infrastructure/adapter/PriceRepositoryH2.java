package com.capitole.tecnicaltest.price.infrastructure.adapter;

import com.capitole.tecnicaltest.price.infrastructure.entity.PriceEntity;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepositoryH2 extends CrudRepository<PriceEntity, Long> {
}
