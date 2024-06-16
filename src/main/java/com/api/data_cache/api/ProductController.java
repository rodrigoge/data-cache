package com.api.data_cache.api;

import com.api.data_cache.dto.ProductTO;
import com.api.data_cache.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@Log4j2
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductTO> createProduct(ProductTO productTO) {
        log.info("Creating a new product - {}", productTO.toString());
        var productResponse = productService.createProduct(productTO);
        log.info("Finishing product created - {}", productResponse.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }
}
