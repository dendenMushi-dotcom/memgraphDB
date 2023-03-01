package com.developer.productmanagement.service.impl;

import com.developer.productmanagement.entity.ProductEntity;
import com.developer.productmanagement.repository.ProductRepository;
import com.developer.productmanagement.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService
{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> findAllProduct(int limit) {
        Iterable<ProductEntity> iterableProducts = productRepository.findAll();
        if (limit < 1) {
            // Return all the products if the limit parameter is not specified or its value is less than 1
            return StreamSupport.stream(iterableProducts.spliterator(), false)
                    .collect(Collectors.toList());
        } else {
            // Limit the number of products returned to the specified limit
            return StreamSupport.stream(iterableProducts.spliterator(), false)
                    .limit(limit)
                    .collect(Collectors.toList());
        }
    }


    @Override
    public Optional<ProductEntity> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public void deleteProduct(Long id) {

    }

//    @Override
//    public void deleteProduct(String name) {
//        // Find the product in the database
//        Optional<ProductEntity> productOptional = productRepository.findByName(name);
//
//        if (productOptional.isPresent()) {
//            // Delete the product from the database
//            productRepository.delete(productOptional.get());
//        }
//    }

}
