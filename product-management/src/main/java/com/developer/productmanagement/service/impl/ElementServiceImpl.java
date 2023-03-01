package com.developer.productmanagement.service.impl;

import com.developer.productmanagement.entity.ComponentEntity;
import com.developer.productmanagement.entity.ElementEntity;
import com.developer.productmanagement.repository.ComponentRepository;
import com.developer.productmanagement.repository.ElementRepository;
import com.developer.productmanagement.service.ElementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElementServiceImpl implements ElementService {

    private final ElementRepository elementRepository;

    public ElementServiceImpl(ElementRepository elementRepository) {
        this.elementRepository = elementRepository;
    }

    @Override
    public List<ElementEntity> findAllElements() {
        return elementRepository.findAll();
    }

    @Override
    public Optional<ElementEntity> findByName(String name) {
        return elementRepository.findByName(name);
    }

    @Override
    public ElementEntity saveElement(ElementEntity elementEntity) {
        return elementRepository.save(elementEntity);
    }

    @Override
    public ElementEntity updateElement(ElementEntity elementEntity) {
        return elementRepository.save(elementEntity);
    }

    @Override
    public void deleteElement(Long id) {
        // Find the product in the database
        Optional<ElementEntity> productOptional = elementRepository.findById(id);

        if (productOptional.isPresent()) {
            // Delete the product from the database
            elementRepository.delete(productOptional.get());
        }
    }
}
