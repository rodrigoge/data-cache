package com.api.data_cache.service;

import com.api.data_cache.db.ProductRepository;
import com.api.data_cache.dto.ProductTO;
import com.api.data_cache.mapper.ProductMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductTO createProduct(ProductTO productTO) {
        log.info("Initializing create product flow - {}", productTO.toString());
        var product = productMapper.fromProductTO(productTO);
        log.info("Saving product in database - {}", product.toString());
        var productCreated = productRepository.save(product);
        log.info("Returning product saved - {}", productCreated.toString());
        var productResponse = productMapper.fromProduct(productCreated);
        log.info("Finishing create product flow - {}", productResponse.toString());
        return productResponse;
    }
}
