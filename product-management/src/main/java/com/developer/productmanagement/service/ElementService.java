package com.developer.productmanagement.service;

import com.developer.productmanagement.entity.ElementEntity;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface ElementService {
    @Query(value = "SELECT * FROM v_memgraph_elements_1", nativeQuery = true)
    List<ElementEntity> findAllElements();
    Optional<ElementEntity> findByName(String name);
    ElementEntity saveElement(ElementEntity elementEntity);
    ElementEntity updateElement(ElementEntity elementEntity);
    void deleteElement(Long id);
}
