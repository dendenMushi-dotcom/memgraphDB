package com.developer.productmanagement;


import org.neo4j.driver.*;
import org.neo4j.driver.Driver;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Query;
import org.neo4j.driver.Record;
import org.neo4j.driver.types.Node;

import static org.neo4j.driver.Values.parameters;



public class NodeCreator {
    private final Driver driver;


    public NodeCreator()  {
        driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "password"));
    }

    public void close() throws RuntimeException {
        driver.close();
    }

    public void createNode(String query) {
        try (Session session = driver.session()) {
            session.run(query);
        }
    }

//    public void createRelationship(String query) {
//        try (Session session = driver.session()) {
//            session.run(query);
//        }
//    }

    public boolean doesRelationshipExist(String materialNumber1, String materialNumber2) {
        String query = "MATCH (n1:Material),(n2:Material) WHERE n1.Material_number = $materialNumber1 AND n2.Material_number = $materialNumber2 MATCH (n1)-[r:CHILD_OF]->(n2) RETURN r";
        try (Session session = driver.session()) {
            Result result = session.run(query, Values.parameters("materialNumber1", materialNumber1, "materialNumber2", materialNumber2));
            return result.hasNext();
        } catch (Exception e) {
            // Handle any exceptions
        }
        return false;
    }


//
////    public boolean nodeExists(Long id) {
////        try (Session session = driver.session()) {
////            Result result = session.run(String.format("MATCH (n:%s {id: '%s'}) return n", id));
////            return result.hasNext();
////        }
////    }
//
////    public void updateNodeProperties(String name, Long id) {
////        try (Session session = driver.session()) {
////            session.run(String.format("MATCH (n:%s)  SET n.id = '%s' return n", name, id));
////        }
////    }
//
//
//    public void deleteNode(String name) {
//        try (Session session = driver.session()) {
//            Result result = session.run(String.format("MATCH (n) WHERE id(n) = %d DETACH DELETE n", name));
//        }
//
//    }


}
