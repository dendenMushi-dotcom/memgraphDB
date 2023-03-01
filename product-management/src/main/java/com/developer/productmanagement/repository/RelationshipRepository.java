package com.developer.productmanagement.repository;

import com.developer.productmanagement.entity.RelationshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RelationshipRepository extends JpaRepository<RelationshipEntity, Long> {
    Optional<RelationshipEntity> findByName(String name);
}
