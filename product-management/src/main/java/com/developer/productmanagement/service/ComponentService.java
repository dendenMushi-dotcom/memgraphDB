package com.developer.productmanagement.service;

import com.developer.productmanagement.entity.ComponentEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ComponentService {
    @Query(value = "SELECT * FROM v_memgraph_components_1", nativeQuery = true)
    List<ComponentEntity> findAllComponents(int limit);
    Optional<ComponentEntity> findByName(String name);
    ComponentEntity saveComponent(ComponentEntity componentEntity);
    ComponentEntity updateComponent(ComponentEntity componentEntity);
    void deleteComponent(Long id);
}
