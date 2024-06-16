package com.api.data_cache.mapper;

import com.api.data_cache.db.Product;
import com.api.data_cache.db.ProductCategory;
import com.api.data_cache.dto.ProductTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T11:20:34-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product fromProductTO(ProductTO productTO) {
        if ( productTO == null ) {
            return null;
        }

        String name = null;
        ProductCategory category = null;
        BigDecimal price = null;
        Integer quantity = null;
        LocalDateTime creationDate = null;

        name = productTO.name();
        category = productTO.category();
        price = productTO.price();
        quantity = productTO.quantity();
        creationDate = productTO.creationDate();

        UUID id = null;

        Product product = new Product( id, name, category, price, quantity, creationDate );

        return product;
    }

    @Override
    public ProductTO fromProduct(Product product) {
        if ( product == null ) {
            return null;
        }

        String name = null;
        ProductCategory category = null;
        BigDecimal price = null;
        Integer quantity = null;
        LocalDateTime creationDate = null;

        name = product.getName();
        category = product.getCategory();
        price = product.getPrice();
        quantity = product.getQuantity();
        creationDate = product.getCreationDate();

        ProductTO productTO = new ProductTO( name, category, price, quantity, creationDate );

        return productTO;
    }
}
