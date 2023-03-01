package com.developer.productmanagement.controller;

import com.developer.productmanagement.NodeCreator;
import com.developer.productmanagement.entity.ComponentEntity;
import com.developer.productmanagement.entity.ProductEntity;
import com.developer.productmanagement.service.ComponentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ComponentController {
    private final ComponentService componentService;

    private final NodeCreator nodeCreator;

    public ComponentController(ComponentService componentService, NodeCreator nodeCreator) {
        this.componentService = componentService;
        this.nodeCreator = nodeCreator;
    }

    @GetMapping("/components")
    public List<ComponentEntity> findAllComponents(@RequestParam(defaultValue = "0") int limit){
        List<ComponentEntity> components = componentService.findAllComponents(limit);
        System.out.println("Retrieved " + components.size() + " products from the database.");

        for (ComponentEntity component : components) {
            // Do something with each product entity
            String[] str = component.getCreateNode().split("\\{", 2);
            //String firstSubstring = str[0].replaceAll("[^a-zA-Z0-9:(-)()]+", "");
            String[] str2 = str[0].split("\\(" , 2);
            String firstSubstring = str2[1].replaceAll("[^a-zA-Z0-9:]+", "_");
            String query = str2[0] + "(" + firstSubstring + "{" + str[1];
            System.out.println(query);
            nodeCreator.createNode(query);
        }
        return components;
    }

    @GetMapping("/components/{name}")
    public Optional<ComponentEntity> findProductByName(@PathVariable("name") String name){
        return componentService.findByName(name);
    }

}
