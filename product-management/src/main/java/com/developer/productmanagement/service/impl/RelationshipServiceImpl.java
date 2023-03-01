package com.developer.productmanagement.service.impl;

import com.developer.productmanagement.entity.ElementEntity;
import com.developer.productmanagement.entity.RelationshipEntity;
import com.developer.productmanagement.repository.ElementRepository;
import com.developer.productmanagement.repository.RelationshipRepository;
import com.developer.productmanagement.service.RelationshipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelationshipServiceImpl implements RelationshipService {

    private final RelationshipRepository relationshipRepository;

    public RelationshipServiceImpl(RelationshipRepository relationshipRepository) {
        this.relationshipRepository = relationshipRepository;
    }

    @Override
    public List<RelationshipEntity> createAllRelationships() {
        return relationshipRepository.findAll();
    }

    @Override
    public Optional<RelationshipEntity> findByName(String name) {
        return relationshipRepository.findByName(name);
    }

    @Override
    public RelationshipEntity saveRelatiopnships(RelationshipEntity relationshipEntity) {
        return relationshipRepository.save(relationshipEntity);
    }

    @Override
    public RelationshipEntity updateRelationships(RelationshipEntity relationshipEntity) {
        return relationshipRepository.save(relationshipEntity);
    }

    @Override
    public List<RelationshipEntity> deleteAllRelationships() {
        return relationshipRepository.findAll();
    }
}
