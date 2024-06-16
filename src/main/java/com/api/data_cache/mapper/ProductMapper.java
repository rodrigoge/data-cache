package com.api.data_cache.mapper;

import com.api.data_cache.db.Product;
import com.api.data_cache.dto.ProductTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    Product fromProductTO(ProductTO productTO);
    ProductTO fromProduct(Product product);
}
