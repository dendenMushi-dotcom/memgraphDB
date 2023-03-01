package com.developer.productmanagement.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "v_memgraph_products_1")
public class ProductEntity {
    @Id
    @Column(name = "sdp_matnr")
    private String name;

    @Column(name = "create_node_script")
    private String createNode;

    @Column(name = "delete_node_script")
    private String deleteNode;



    public ProductEntity(){
    }

    public ProductEntity(String name, String createNode, String deleteNode) {
        this.name = name;
        this.createNode = createNode;
        this.deleteNode = deleteNode;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getCreateNode() {
        return createNode;
    }

    public void setCreateNode(String createNode) {
        this.createNode = createNode;
    }

    public String getDeleteNode() {
        return deleteNode;
    }

    public void setDeleteNode(String deleteNode) {
        this.deleteNode = deleteNode;
    }

}
