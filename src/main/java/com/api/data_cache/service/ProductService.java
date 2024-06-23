package com.api.data_cache.service;

import com.api.data_cache.db.Product;
import com.api.data_cache.db.ProductRepository;
import com.api.data_cache.dto.ProductTO;
import com.api.data_cache.mapper.ProductMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private EntityManager entityManager;

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

    @Cacheable("products")
    public List<ProductTO> getProducts(String name, Integer offset, Integer limit) {
        log.info("Initializing get products flow - Name: {}, Offset: {}, Limit: {}", name, offset, limit);
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var criteriaQuery = criteriaBuilder.createQuery(Product.class);
        var root = criteriaQuery.from(Product.class);
        var predicates = buildPredicates(criteriaBuilder, root, name);
        criteriaQuery.select(root).where(predicates.toArray(new Predicate[0]));
        var productQuery = entityManager.createQuery(criteriaQuery);
        productQuery.setFirstResult(offset);
        productQuery.setMaxResults(limit);
        var products = productQuery.getResultList();
        var response = buildProducts(products);
        log.info("Finishing get products flow - Size: {}", response.size());
        return response;
    }

    private List<Predicate> buildPredicates(CriteriaBuilder criteriaBuilder,
                                            Root<Product> root,
                                            String name) {
        log.info("Building predicates to get products Name: {}", name);
        var predicates = new ArrayList<Predicate>();
        if (StringUtils.isNotBlank(name)) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
        }
        return predicates;
    }

    private List<ProductTO> buildProducts(List<Product> products) {
        return products.stream().map(productMapper::fromProduct).toList();
    }
}
