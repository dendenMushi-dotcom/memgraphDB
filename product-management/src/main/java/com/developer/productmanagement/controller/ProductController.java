package com.developer.productmanagement.controller;

import com.developer.productmanagement.NodeCreator;
import com.developer.productmanagement.entity.ComponentEntity;
import com.developer.productmanagement.entity.ProductEntity;
import com.developer.productmanagement.service.ComponentService;
import com.developer.productmanagement.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {


    private final ProductService productService;

    private final NodeCreator nodeCreator;


    public ProductController(ProductService productService, NodeCreator nodeCreator) {
        this.productService = productService;
        this.nodeCreator = nodeCreator;
    }
    @GetMapping("/products")
    public List<ProductEntity> findAllProduct(@RequestParam(defaultValue = "0") int limit){
        List<ProductEntity> products = productService.findAllProduct(limit);
        System.out.println("Retrieved " + products.size() + " products from the database.");

        for (ProductEntity product : products) {
            // Do something with each component entity
            String[] str = product.getCreateNode().split("\\{", 2);
            String firstSubstring = str[0].replaceAll("[^a-zA-Z0-9:(]+", "");
            String query = firstSubstring + "{" + str[1];
            nodeCreator.createNode(query);
        }
        return products;
    }


    @GetMapping("/products/{name}")
    public Optional<ProductEntity> findProductByName(@PathVariable("name") String name){
        return productService.findByName(name);
    }

    @PostMapping
    public ProductEntity saveProduct(@RequestBody ProductEntity productEntity){
        return productService.saveProduct(productEntity);
    }

//    @PutMapping("/{id}")
//    public ProductEntity updateProduct(@PathVariable("id") Long id, @RequestBody ProductEntity productEntity) {
//        productEntity.setId(id);
//        return productService.updateProduct(productEntity);
//    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") String name){
    Optional<ProductEntity> product = productService.findByName(name);
        //nodeCreator.createNode(query);
            // Delete the node from the graph database
            //nodeCreator.deleteNode(id);
            // Delete the product from the SQL database
            //productService.deleteProduct(name);
    }

}
