package com.api.data_cache.mapper;

import com.api.data_cache.db.Product;
import com.api.data_cache.db.ProductCategory;
import com.api.data_cache.dto.ProductTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-23T08:58:36-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product fromProductTO(ProductTO productTO) {
        if ( productTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( productTO.name() );
        product.setCategory( productTO.category() );
        product.setPrice( productTO.price() );
        product.setQuantity( productTO.quantity() );
        product.setCreationDate( productTO.creationDate() );

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
