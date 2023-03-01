package com.developer.productmanagement.repository;

import com.developer.productmanagement.entity.ComponentEntity;
import com.developer.productmanagement.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComponentRepository extends JpaRepository<ComponentEntity, Long> {
    Optional<ComponentEntity> findByName(String name);
}
