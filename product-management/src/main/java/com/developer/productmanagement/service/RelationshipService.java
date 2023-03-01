package com.developer.productmanagement.service;

import com.developer.productmanagement.entity.ElementEntity;
import com.developer.productmanagement.entity.RelationshipEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RelationshipService {
    @Query(value = "SELECT * FROM v_memgraph_elements_1", nativeQuery = true)
    List<RelationshipEntity> createAllRelationships();
    Optional<RelationshipEntity> findByName(String name);
    RelationshipEntity saveRelatiopnships(RelationshipEntity relationshipEntity);
    RelationshipEntity updateRelationships(RelationshipEntity relationshipEntity);
    List<RelationshipEntity> deleteAllRelationships();
}
