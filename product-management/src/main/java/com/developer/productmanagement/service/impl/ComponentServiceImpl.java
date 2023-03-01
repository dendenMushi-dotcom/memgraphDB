package com.developer.productmanagement.service.impl;

import com.developer.productmanagement.entity.ComponentEntity;
import com.developer.productmanagement.entity.ProductEntity;
import com.developer.productmanagement.repository.ComponentRepository;
import com.developer.productmanagement.service.ComponentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ComponentServiceImpl implements ComponentService {


    private final ComponentRepository componentRepository;

    public ComponentServiceImpl(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

//    @Override
//    public List<ComponentEntity> findAllComponents() {
//        return componentRepository.findAll();
//    }

    @Override
    public List<ComponentEntity> findAllComponents(int limit) {
        Iterable<ComponentEntity> iterableComponents = componentRepository.findAll();
        if (limit < 1) {
            // Return all the products if the limit parameter is not specified or its value is less than 1
            return StreamSupport.stream(iterableComponents.spliterator(), false)
                    .collect(Collectors.toList());
        } else {
            // Limit the number of products returned to the specified limit
            return StreamSupport.stream(iterableComponents.spliterator(), false)
                    .limit(limit)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Optional<ComponentEntity> findByName(String name) {
        return componentRepository.findByName(name);
    }

    @Override
    public ComponentEntity saveComponent(ComponentEntity componentEntity) {
        return componentRepository.save(componentEntity);
    }

    @Override
    public ComponentEntity updateComponent(ComponentEntity componentEntity) {
        return componentRepository.save(componentEntity);
    }

    @Override
    public void deleteComponent(Long id) {
        // Find the product in the database
        Optional<ComponentEntity> productOptional = componentRepository.findById(id);

        if (productOptional.isPresent()) {
            // Delete the product from the database
            componentRepository.delete(productOptional.get());
        }
    }
}
