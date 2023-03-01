package com.developer.productmanagement.controller;

import com.developer.productmanagement.NodeCreator;
import com.developer.productmanagement.entity.ElementEntity;
import com.developer.productmanagement.service.ElementService;
import org.neo4j.driver.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ElementController {

    private final ElementService elementService;

    private final NodeCreator nodeCreator;

    public ElementController(ElementService elementService, NodeCreator nodeCreator) {
        this.elementService = elementService;
        this.nodeCreator = nodeCreator;
    }

    @GetMapping("/elements")
    public List<ElementEntity> findAllComponents(){
        List<ElementEntity> elements = elementService.findAllElements();
        System.out.println("Retrieved " + elements.size() + " products from the database.");

        for (ElementEntity element : elements) {
            // Do something with each product entity
            //String query = element.getCreateNode();
            String[] str = element.getCreateNode().split("\\{", 2);
            //String firstSubstring = str[0].replaceAll("[^a-zA-Z0-9:(-)()]+", "");
            String[] str2 = str[0].split("\\(" , 2);
            String firstSubstring = str2[1].replaceAll("[^a-zA-Z0-9:]+", "_");
            String query = str2[0] + "(" + firstSubstring + "{" + str[1];
            System.out.println(query);
            nodeCreator.createNode(query);
            //System.out.println(result);
        }
        return elements;
    }

    @GetMapping("/elements/{name}")
    public Optional<ElementEntity> findProductByName(@PathVariable("name") String name){
        return elementService.findByName(name);
    }

}
