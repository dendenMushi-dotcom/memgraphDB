package com.developer.productmanagement.controller;

import com.developer.productmanagement.NodeCreator;
import com.developer.productmanagement.entity.RelationshipEntity;
import com.developer.productmanagement.service.RelationshipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class RelationshipController {

    private final RelationshipService relationshipService;

    private final NodeCreator nodeCreator;

    public RelationshipController(RelationshipService relationshipService, NodeCreator nodeCreator) {
        this.relationshipService = relationshipService;
        this.nodeCreator = nodeCreator;
    }

    @GetMapping("/relationships")
    public List<RelationshipEntity> createAllRelationship(){
        List<RelationshipEntity> relationships = relationshipService.createAllRelationships();
        System.out.println("Retrieved " + relationships.size() + " products from the database.");

        for (RelationshipEntity relationship : relationships) {
            String material1 = relationship.getName();
            String material2 = relationship.getParentMaterialId();
            System.out.println(material1);
            System.out.println(material2);
            // Check if relationship already exists
            if (!nodeCreator.doesRelationshipExist(material1, material2)) {
                // Create relationship if it doesn't exist
                String query = relationship.getCreatRelationNode();
                nodeCreator.createNode(query);
            }
        }
        return relationships;
    }



    @GetMapping("/realationships/{name}")
    public Optional<RelationshipEntity> findProductByName(@PathVariable("name") String name){
        return relationshipService.findByName(name);
    }

    @DeleteMapping("relationships")
    public List<RelationshipEntity> deleteAllRelationships(){
        List<RelationshipEntity> relationships = relationshipService.deleteAllRelationships();
        System.out.println("Retrieved " + relationships.size() + " products from the database.");

        for (RelationshipEntity relationship : relationships) {
            // Do something with each product entity
            String query = relationship.getDeleteRelationChild();
            nodeCreator.createNode(query);
            query = relationship.getDeleteRelationParent();
            nodeCreator.createNode(query);
        }
        return relationships;
        //nodeCreator.createNode(query);
        // Delete the node from the graph database
        //nodeCreator.deleteNode(id);
        // Delete the product from the SQL database
        //productService.deleteProduct(name);
    }
}
