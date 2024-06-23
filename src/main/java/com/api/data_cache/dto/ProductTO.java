package com.api.data_cache.dto;

import com.api.data_cache.db.ProductCategory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductTO(String name,
                        ProductCategory category,
                        BigDecimal price,
                        Integer quantity,
                        LocalDateTime creationDate) implements Serializable {
}
