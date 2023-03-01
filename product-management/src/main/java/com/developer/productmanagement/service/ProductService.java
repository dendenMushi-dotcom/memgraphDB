package com.developer.productmanagement.service;

import com.developer.productmanagement.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    @Query(value = "SELECT * FROM v_memgraph_products_1", nativeQuery = true)
    List<ProductEntity> findAllProduct(int limit);
    Optional<ProductEntity> findByName(String name);
    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity updateProduct(ProductEntity productEntity);
    void deleteProduct(Long id);

}
