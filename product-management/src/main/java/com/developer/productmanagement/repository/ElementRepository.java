package com.developer.productmanagement.repository;

import com.developer.productmanagement.entity.ComponentEntity;
import com.developer.productmanagement.entity.ElementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElementRepository extends JpaRepository<ElementEntity, Long> {
    Optional<ElementEntity> findByName(String name);
}
