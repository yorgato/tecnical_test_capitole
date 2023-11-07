package com.capitole.tecnicaltest.price.infrastructure.adapter;

import com.capitole.tecnicaltest.price.infrastructure.entity.PriceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriceRepositoryH2 extends CrudRepository<PriceEntity, Long> {

    @Query(value = "SELECT * FROM PRICES " +
            " WHERE " +
            " PRODUCT_ID=:productId AND BRAND_ID=:brandId " +
            " AND (:applicationDate BETWEEN START_DATE AND END_DATE) " +
            " ORDER BY PRIORITY DESC", nativeQuery = true)
    List<PriceEntity> getPrice(
            @Param("applicationDate") String applicationDate,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId
    );
}
