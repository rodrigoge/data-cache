package com.api.data_cache.api;

import com.api.data_cache.dto.ProductTO;
import com.api.data_cache.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ProductTO>> getProducts(String name, Integer offset, Integer limit) {
        log.info("Getting products - Name: {}, Offset: {}, Limit: {}", name, offset, limit);
        var products = productService.getProducts(name, offset, limit);
        log.info("Finishing getting products - Size: {}, Name: {}, Offset: {}, Limit: {}",
                products.size(),
                name,
                offset,
                limit
        );
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/cache")
    public ResponseEntity<List<ProductTO>> getProductsCache(String name, Integer offset, Integer limit) {
        log.info("Getting products with cache - Name: {}, Offset: {}, Limit: {}", name, offset, limit);
        var products = productService.getProducts(name, offset, limit);
        log.info("Finishing getting products with cache - Size: {}, Name: {}, Offset: {}, Limit: {}",
                products.size(),
                name,
                offset,
                limit
        );
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
}
